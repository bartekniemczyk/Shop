package com.bartek.controller;

import com.bartek.dao.Product;
import com.bartek.service.ProductService;
import org.hibernate.QueryParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Bartek on 22.03.2017.
 */
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", this.productService.getAllProducts());
        return "products";
    }


    @RequestMapping(value = "/edit/{id}/{count}", method = RequestMethod.GET)
    public String process(@PathVariable("id") int id, @PathVariable("count") int count, Model model) {
        this.productService.processOrder(id, count);
        model.addAttribute("products", this.productService.getAllProducts());
        return "redirect:/products";
    }
    @RequestMapping(value = "/products/{category}", method = RequestMethod.GET)
    String findProductByCategory(@PathVariable("category") String category, Model model){

        model.addAttribute("products", this.productService.getAllProducts()
                .stream()
                .filter(product -> Objects.equals(product.getCategory(),category))
                .collect(Collectors.toList()));
        return "products";
    }
}