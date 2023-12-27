package com.ra.model.dao;

import com.ra.model.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Product> findAll() {
        Session session=sessionFactory.openSession();
        List<Product> productList=new ArrayList<>();
        try{
            productList=session.createQuery("from Product ",Product.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return productList;
    }

    @Override
    public boolean save(Product product) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean update(Product product) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public Product findById(Integer id) {
        Session session=sessionFactory.openSession();
        try {
           Product product= session.get(Product.class,id);
           return product;
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
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
