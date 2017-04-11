package com.bartek.dao.repository.impl;

import com.bartek.dao.Product;
import com.bartek.dao.repository.ProductDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


/**
 * Created by Bartek on 22.03.2017.
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

    SessionFactory sessionFactory;
    List<Product> listOfProducts;

    public ProductDAOImpl() {
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Product> getAllProducts() {
        Session session = getSessionFactory().openSession();

        listOfProducts = session.createQuery("from Product ").list();
        session.close();

        return listOfProducts;
    }

    @Override
    public void addProdukt(Product product) {
        Session session=this.sessionFactory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(product);
        tx.commit();
        session.close();
    }

    @Override
    public Product getProductByID(int productId) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Product product = (Product) session.get(Product.class, new Integer(productId));
        tx.commit();
        session.close();
        return product;
    }

    @Override
    public void updateProduct(Product product) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(product);
        tx.commit();
        session.close();
    }

    @Override
    public List<Product> getProductByManufacturer(String manufacturer) {
        List<Product> productsByManufacturer = new ArrayList<>();
        for (Product product : listOfProducts) {
            if (manufacturer.equalsIgnoreCase(product.getManufacturer())) {
                productsByManufacturer.add(product);
            }

        }
        return productsByManufacturer;
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        List<Product> productsByCategory = new ArrayList<>();
        for (Product product : listOfProducts) {
            if (category.equalsIgnoreCase(product.getCategory())) {
                productsByCategory.add(product);
            }
        }
        return productsByCategory;

    }

    @Override
    public Set<Product> getProductByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<>();
        Set<Product> productsByCategory = new HashSet<>();
        Set<Product> productsByMin = new HashSet<>();
        Set<Product> productsByMax = new HashSet<>();
        Set<String> criteria = filterParams.keySet();
        Set<BigDecimal> bigDecimals = new HashSet<>();

        if (criteria.contains("min")) {
            for(String min:filterParams.get("min")){
                bigDecimals.add(new BigDecimal(min.replaceAll(",", "")));
                for (Product product:listOfProducts){
                    for (BigDecimal bd:bigDecimals){
                        if (bd.compareTo(product.getUnitPrice())>=0);
                        productsByMin.add(product);
                    }

                }
            }

        }else productsByMin.addAll(listOfProducts);

        if (criteria.contains("max")) {
            for(String max:filterParams.get("max")){
                bigDecimals.add(new BigDecimal(max.replaceAll(",", "")));
                for (Product product:listOfProducts){
                    for (BigDecimal bd:bigDecimals){
                        if (bd.compareTo(product.getUnitPrice())<=0);
                        productsByMax.add(product);
                    }

                }
            }

        }else productsByMax.addAll(listOfProducts);
        productsByMax.retainAll(productsByMin);

        if (criteria.contains("brand")) {
            for (String brandName : filterParams.get("brand")) {
                for (Product product : listOfProducts) {
                    if (brandName.equalsIgnoreCase(product.getManufacturer())) {
                        productsByBrand.add(product);
                    }
                }
            }
        } else productsByBrand.addAll(listOfProducts);
        if (criteria.contains("category")) {
            for (String categoryName : filterParams.get("category")) {
                productsByCategory.addAll(this.getProductByCategory(categoryName));
            }
        } else productsByCategory.addAll(listOfProducts);

        productsByCategory.retainAll(productsByMax);
        productsByCategory.retainAll(productsByBrand);

        return productsByCategory;
    }



    @Override
    public List<Product> getProductsInPriceRange(BigDecimal min, BigDecimal max) {


        List<Product> productsInPriceRange = listOfProducts.stream()
                .filter(product -> product.getUnitPrice().compareTo(min) >= 0)
                .filter(product -> product.getUnitPrice().compareTo(max) <= 0)
                .collect(Collectors.toList());

        return productsInPriceRange;


    }


}