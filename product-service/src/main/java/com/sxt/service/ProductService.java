package com.sxt.service;

import com.sxt.entity.Product;

public interface ProductService {

    Product findById(long id);

    void save(Product product);

    void delById(long id);

    void update(Product product);
}
