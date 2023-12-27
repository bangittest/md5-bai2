package com.ra.model.service;

import com.ra.model.entity.User;

import java.util.List;
public interface UserService {
    List<User> findAll();
    boolean save(User user);
    boolean update(User user);
    User findById(Integer id);
    void delete(Integer id);
}
