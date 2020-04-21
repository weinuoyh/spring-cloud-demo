package com.controller;

import com.service.ProductService;
import com.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("/findbyid")
    public Product findById(@RequestParam(value = "id") long id) {
        Product product = productService.findById(id);
        return product;
    }

}
