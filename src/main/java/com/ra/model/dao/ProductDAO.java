package com.ra.model.dao;

import com.ra.model.entity.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    boolean save(Product product);
    boolean update(Product product);
    Product findById(Integer id);
    void delete(Integer id);
}
