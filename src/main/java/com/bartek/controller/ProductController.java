package com.bartek.controller;

import com.bartek.domain.Product;
import com.bartek.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

/**
 * Created by Bartek on 22.03.2017.
 */
@Controller
public class ProductController {
@Autowired
private ProductRepository productRepository;

    @RequestMapping("/products")
    public String list(Model model){

        model.addAttribute("products", productRepository.getAllProducts());
        return "products";
    }
}
