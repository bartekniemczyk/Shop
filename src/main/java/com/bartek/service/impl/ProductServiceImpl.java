package com.bartek.service.impl;

import com.bartek.dao.Product;
import com.bartek.dao.repository.ProductDAO;
import com.bartek.service.ProductService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
    public void processOrder(int productId, int count) {
        Product product = this.productDAO.getProductByID(productId);
        if (product.getUnitsInStock() < count) {
            throw new IllegalArgumentException("Za mało sztuk w magazynie. Ilość sztuk: " + product.getUnitsInStock());
        }
        product.setUnitsInStock(product.getUnitsInStock() - count);
        updateProduct(product);

    }


    @Override
    public void updateProduct(Product product) {
        this.productDAO.updateProduct(product);
    }


}

