package com.ra.model.dao;

import com.ra.model.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryImpl implements CategoryDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Category> findAll() {
        List<Category> categoryList=new ArrayList<>();
        Session session= sessionFactory.openSession();
        try {
            categoryList = session.createQuery("from Category ",Category.class).list();
            return categoryList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return categoryList;
    }

    @Override
    public boolean save(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public Category findById(Integer id) {
        Session session=sessionFactory.openSession();
        try {
            Category category= session.find(Category.class,id);
            return category;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean update(Category category) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public void delete(Integer id) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }
}
