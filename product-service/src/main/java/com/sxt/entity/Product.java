package com.sxt.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    private long ID;
    private String name;
    private BigDecimal price;
    private String status;

}
