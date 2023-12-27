package com.ra.model.service;

import com.ra.model.dao.UserDAO;
import com.ra.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDAO userDAO;
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public boolean save(User user) {
        return userDAO.save(user);
    }

    @Override
    public boolean update(User user) {
        return userDAO.update(user);
    }

    @Override
    public User findById(Integer id) {
        return userDAO.findById(id);
    }

    @Override
    public void delete(Integer id) {
        userDAO.delete(id);
    }
}
