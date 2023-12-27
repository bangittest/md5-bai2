package com.ra.model.dao;

import com.ra.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<User> findAll() {
        List<User> userList=new ArrayList<>();
        Session session=sessionFactory.openSession();
        try {
            userList=session.createQuery("from User ",User.class).list();
            return userList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean save(User user) {
        Session session=sessionFactory.openSession();
        try {
            session.getTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        Session session=sessionFactory.openSession();
        try {
            session.getTransaction();
            session.update(user);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public User findById(Integer id) {
        Session session=sessionFactory.openSession();
        try {
            User user=session.find(User.class,id);
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        Session session=sessionFactory.openSession();
        try {
            session.getTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
