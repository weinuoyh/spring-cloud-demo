package com.jwt.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SysUser {
    private long ID;
    private String username;
    private BigDecimal price;
    private String status;
    private String password;
}
