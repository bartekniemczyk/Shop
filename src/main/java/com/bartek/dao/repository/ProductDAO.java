package com.bartek.dao.repository;

import com.bartek.dao.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Bartek on 22.03.2017.
 */

public interface ProductDAO {
    List<Product> getAllProducts();

    Product getProductByID(int productId);

    void addProdukt(Product product);

    void updateProduct(Product product);

    List<Product> getProductByCategory(String category);

    Set<Product> getProductByFilter(Map<String, List<String>> filterParams);

    List<Product> getProductByManufacturer(String manufacturer);

    List<Product> getProductsInPriceRange(BigDecimal min, BigDecimal max);
    // Set<Product> getProductByPrice(Map<String, List<String>> filterParams);

}
