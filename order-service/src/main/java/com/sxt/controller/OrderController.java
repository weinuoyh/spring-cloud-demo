package com.sxt.controller;

import com.sxt.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("findorder")
public Product order(@RequestParam(value = "orderid") long id){
        Product product = restTemplate.getForObject("http://SERVICE-PRODUCT/product/findbyid?id="+id, Product.class);
        System.out.println(product.toString());
        logger.info("成功");
        return product;
}

}
