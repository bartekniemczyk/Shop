package com.bartek.service;

import com.bartek.dao.Product;

import java.util.List;

/**
 * Created by Bartek on 29.03.2017.
 */
public interface ProductService {
     List<Product> getAllProducts();
    void processOrder(int productId, int count);

    void updateProduct(Product product);


}
