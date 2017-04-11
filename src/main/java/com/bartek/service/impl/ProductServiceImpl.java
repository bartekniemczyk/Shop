package com.bartek.service.impl;

import com.bartek.dao.Product;
import com.bartek.dao.repository.ProductDAO;
import com.bartek.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Bartek on 29.03.2017.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO;

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    @Override
    public List<Product> getAllProducts() {
        return this.productDAO.getAllProducts();
    }

    @Override
    public void addProduct(Product product) {
        productDAO.addProdukt(product);
    }

    @Override
    public void processOrder(int productId, int count) {
        Product product = this.productDAO.getProductByID(productId);
        if (product.getUnitsInStock() < count) {
            throw new IllegalArgumentException("Za mało sztuk w magazynie. Ilość sztuk: " + product.getUnitsInStock());
        }
        product.setUnitsInStock(product.getUnitsInStock() - count);
        updateProduct(product);

    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return this.productDAO.getProductByCategory(category);
    }

    @Override
    public void updateProduct(Product product) {
        this.productDAO.updateProduct(product);
    }

    @Override
    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        return this.productDAO.getProductByFilter(filterParams);
    }

    @Override
    public Product getProductByID(int productId) {
        return productDAO.getProductByID(productId);
    }

    @Override
    public List<Product> getProductsInPriceRange(BigDecimal min, BigDecimal max) {
        return productDAO.getProductsInPriceRange(min, max);
    }

    @Override
    public List<Product> getProductByManufacturer(String manufacturer) {
        return productDAO.getProductByManufacturer(manufacturer);
    }


}

