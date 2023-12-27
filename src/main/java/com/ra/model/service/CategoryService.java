package com.ra.model.service;

import com.ra.model.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> findAll();
    boolean save(Category category);
    Category findById(Integer id);
    boolean update(Category category);
    void delete(Integer id);
}
