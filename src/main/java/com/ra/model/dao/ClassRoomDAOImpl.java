package com.ra.model.dao;

import com.ra.model.entity.ClassRoom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClassRoomDAOImpl implements ClassroomDAO{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<ClassRoom> findAll() {
        Session session=sessionFactory.openSession();
        List<ClassRoom> classRooms=new ArrayList<>();
        try {
            classRooms=session.createQuery("from ClassRoom ",ClassRoom.class).list();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return classRooms;
    }

    @Override
    public boolean save(ClassRoom classRoom) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(classRoom);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            if (session.getTransaction()==null){
                session.getTransaction().rollback();
            }
        }
        return false;
    }

    @Override
    public boolean update(ClassRoom classRoom) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.update(classRoom);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
                session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public ClassRoom findById(Integer id) {
        Session session=sessionFactory.openSession();
        try {
            ClassRoom classRoom=session.get(ClassRoom.class,id);
            return classRoom;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public void delete(ClassRoom classRoom) {
        Session session=sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(classRoom);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }
}
