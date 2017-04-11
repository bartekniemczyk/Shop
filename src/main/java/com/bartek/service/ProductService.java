package com.bartek.service;

import com.bartek.dao.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Bartek on 29.03.2017.
 */
public interface ProductService {
    List<Product> getAllProducts();

    void processOrder(int productId, int count);

    Product getProductByID(int productId);

    void updateProduct(Product product);

    List<Product> getProductByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    List<Product> getProductsInPriceRange(BigDecimal min, BigDecimal max);

    List<Product> getProductByManufacturer(String manufacturer);

    void addProduct(Product product);
}
