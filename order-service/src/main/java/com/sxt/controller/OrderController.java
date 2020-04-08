package com.sxt.controller;

import com.sxt.entity.Product;
import com.sxt.entity.TbOrder;
import com.sxt.service.ITbOrderService;
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
    @Autowired
    ITbOrderService iTbOrderService;
    @RequestMapping("findorder")
public Product order(@RequestParam(value = "orderid") long id){
        Product product = restTemplate.getForObject("http://SERVICE-PRODUCT/product/findbyid?id="+id, Product.class);
        System.out.println(product.toString());
        logger.info("成功");
        return product;   
}
    @RequestMapping("/test")
    public String test() {

        return "ok";
    }
    @RequestMapping("findorderByOrderid")
    public TbOrder findorderByOrderid(@RequestParam(value = "orderid") long id){
        TbOrder tbOrder = iTbOrderService.getById(id);

        logger.info("成功");
        return tbOrder;
    }
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}


