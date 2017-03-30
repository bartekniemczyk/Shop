package com.bartek.dao.repository;

import com.bartek.dao.Product;

import java.util.List;

/**
 * Created by Bartek on 22.03.2017.
 */

public interface ProductDAO {
    List<Product> getAllProducts();

    Product getProductByID(int productId);

    void updateProduct(Product product);


}
