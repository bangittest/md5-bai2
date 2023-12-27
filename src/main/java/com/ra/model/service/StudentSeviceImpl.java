package com.ra.model.service;

import com.ra.model.dao.StudentDAO;
import com.ra.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSeviceImpl implements StudentService{
    @Autowired
    StudentDAO studentDAO;
    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public boolean save(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public boolean update(Student student) {
        return studentDAO.update(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentDAO.findById(id);
    }

    @Override
    public void delete(Integer id) {
        studentDAO.delete(id);
    }
}
