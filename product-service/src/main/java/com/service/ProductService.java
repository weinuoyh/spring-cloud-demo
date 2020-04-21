package com.service;

import com.entity.Product;

public interface ProductService {

    Product findById(long id);

    void save(Product product);

    void delById(long id);

    void update(Product product);
}
