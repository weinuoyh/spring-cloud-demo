package com.sxt.entity;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Product {
    private long ID;
    private String name;
    private BigDecimal price;
    private String status;
}
