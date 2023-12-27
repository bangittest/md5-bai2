package com.ra.model.dao;

import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
    boolean save(Category category);
    Category findById(Integer id);
    boolean update(Category category);
    void delete(Integer id);

}
