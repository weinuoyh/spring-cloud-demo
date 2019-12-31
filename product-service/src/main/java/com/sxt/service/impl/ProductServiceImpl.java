package com.sxt.service.impl;

import com.sxt.dao.ProductDao;
import com.sxt.entity.Product;
import com.sxt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;
    @Override
    public Product findById(long id) {
       Product product = productDao.findById(id).get();
        return product;
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void delById(long id) {
        productDao.deleteById(id);
    }

    @Override
    public void update(Product product) {
        productDao.save(product);
    }
}
