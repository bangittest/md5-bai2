package com.ra.model.dao;

import com.ra.model.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();
    boolean save(User user);
    boolean update(User user);
    User findById(Integer id);
    void delete(Integer id);
}
