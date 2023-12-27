package com.ra.model.service;

import com.ra.model.dao.ProductDAO;
import com.ra.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductDAO productDAO;
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public boolean save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productDAO.update(product);
    }

    @Override
    public Product findById(Integer id) {
        return productDAO.findById(id);
    }

    @Override
    public void delete(Integer id) {
        productDAO.delete(id);
    }
}
