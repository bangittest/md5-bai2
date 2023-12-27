package com.ra.model.dao;

import com.ra.model.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Student> findAll() {
        Session session=sessionFactory.openSession();
        List<Student> studentList=new ArrayList<>();
        try {
            studentList=session.createQuery("from Student",Student.class).list();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return studentList;
    }

    @Override
    public boolean save(Student student) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(student);
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
    public boolean update(Student student) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(student);
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
    public Student findById(Integer id) {
        Session session=sessionFactory.openSession();
        try {
            Student student=session.get(Student.class,id);
            return student;
        }catch (Exception e){
            e.printStackTrace();
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
        }finally {
            session.close();
        }
    }
}
