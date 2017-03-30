package com.bartek.controller;

import com.bartek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bartek on 22.03.2017.
 */
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    @Qualifier(value = "productService")
    public void setProductService(ProductService pS) {
        this.productService = pS;
    }

    @RequestMapping("/products")
    public String list(Model model) {
        model.addAttribute("products", this.productService.getAllProducts());
        return "products";
    }



    @RequestMapping("/edit/{id}/{count}")
    public String process(@PathVariable("id") int id, @PathVariable("count") int count, Model model) {
        this.productService.processOrder(id,count);
        model.addAttribute("products", this.productService.getAllProducts());
        return "redirect:/products";
    }
}