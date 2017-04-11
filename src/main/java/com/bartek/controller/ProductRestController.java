package com.bartek.controller;

import com.bartek.dao.Product;
import com.bartek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Bartek on 01.04.2017.
 */
@RestController
public class ProductRestController {
@Autowired
private ProductService productService;

    @RequestMapping(value = "/products.json", method = RequestMethod.GET)
    public List<Product> getProduct(){
        List<Product> products= new ArrayList<Product>();
products.addAll(this.productService.getAllProducts());
return products;
    }
    @RequestMapping(value = "/products/{category}.json", method = RequestMethod.GET)
    List<Product> findProductByCategory(@PathVariable("category") String category){

        return this.productService.getAllProducts()
                .stream()
                .filter(product -> Objects.equals(product.getCategory(),category))
                .collect(Collectors.toList());
    }

}
