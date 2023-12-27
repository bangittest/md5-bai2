package com.ra.model.service;

import com.ra.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    boolean save(Student student);
    boolean update(Student student);
    Student findById(Integer id);
    void delete(Integer id);
}
