package com.bartek.domain.repository;

import com.bartek.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Bartek on 22.03.2017.
 */

public interface ProductRepository {
    List<Product> getAllProducts();
}
