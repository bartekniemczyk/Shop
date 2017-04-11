package com.bartek.controller;

import com.bartek.dao.Product;
import com.bartek.service.ProductService;
import org.hibernate.QueryParameterException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by Bartek on 22.03.2017.
 */
@RequestMapping("/products")
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;


    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", this.productService.getAllProducts());
        return "products";
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String getProductById(@RequestParam("id") int id, Model model) {
        model.addAttribute("product", this.productService.getProductByID(id));
        return "product";
    }

    @RequestMapping(value = "/manufacturer", method = RequestMethod.GET)
    public String findProductByManufacturer(@RequestParam("name") String manufacturer, Model model) {
        model.addAttribute("products", this.productService.getProductByManufacturer(manufacturer));
        return "products";
    }

    @RequestMapping(value = "/edit/{id}/{count}", method = RequestMethod.GET)
    public String process(@PathVariable("id") int id, @PathVariable("count") int count, Model model) {
        this.productService.processOrder(id, count);
        model.addAttribute("products", this.productService.getAllProducts());
        return "redirect:/products";
    }

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public String findProductByCategory(@PathVariable("category") String category, Model model) {

        model.addAttribute("products", this.productService.getAllProducts()
                .stream()
                .filter(product -> Objects.equals(product.getCategory(), category))
                .collect(Collectors.toList()));
        return "products";
    }

    @RequestMapping(value = "/{min}/{max}", method = RequestMethod.GET)
    public String findProductByCategoryAndPrice(@PathVariable("min") BigDecimal minPrice,
                                                @PathVariable("max") BigDecimal maxPrice, Model model) {

        model.addAttribute("products", this.productService.getProductsInPriceRange(minPrice, maxPrice));

        return "products";
    }

    @RequestMapping("/filter/{xx}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "xx")
                                              Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products", productService.getProductsByFilter(filterParams));
        return "products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(Model model) {
        Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProdukt";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded) {
        productService.addProduct(productToBeAdded);

        return "redirect:/products";
    }

}

