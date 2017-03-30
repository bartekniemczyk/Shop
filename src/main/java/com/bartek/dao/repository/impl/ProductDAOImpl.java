package com.bartek.dao.repository.impl;

import com.bartek.dao.Product;
import com.bartek.dao.repository.ProductDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;


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

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> getAllProducts() {
        Session session = getSessionFactory().openSession();

        listOfProducts = session.createQuery("from Product ").list();
        session.close();

        return listOfProducts;
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
}