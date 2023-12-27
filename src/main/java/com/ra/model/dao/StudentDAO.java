package com.ra.model.dao;

import com.ra.model.entity.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> findAll();
    boolean save(Student student);
    boolean update(Student student);
    Student findById(Integer id);
    void delete(Integer id);

}
