package com.ra.model.service;

import com.ra.model.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> findAll();
    boolean save(Product product);
    boolean update(Product product);
    Product findById(Integer id);
    void delete(Integer id);
}
