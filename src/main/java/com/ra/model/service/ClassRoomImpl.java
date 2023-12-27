package com.ra.model.service;

import com.ra.model.dao.ClassroomDAO;
import com.ra.model.entity.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomImpl implements ClassRoomService {
    @Autowired
    ClassroomDAO classroomDAO;
    @Override
    public List<ClassRoom> findAll() {
        return classroomDAO.findAll();
    }

    @Override
    public boolean save(ClassRoom classRoom) {
        return classroomDAO.save(classRoom);
    }

    @Override
    public boolean update(ClassRoom classRoom) {
        return classroomDAO.update(classRoom);
    }

    @Override
    public ClassRoom findById(Integer id) {
        return classroomDAO.findById(id);
    }

    @Override
    public void delete(ClassRoom classRoom) {

    }
}
