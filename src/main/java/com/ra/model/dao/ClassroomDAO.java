package com.ra.model.dao;

import com.ra.model.entity.ClassRoom;

import java.util.List;

public interface ClassroomDAO {
    List<ClassRoom>findAll();
    boolean save(ClassRoom classRoom);
    boolean update(ClassRoom classRoom);
    ClassRoom findById(Integer id);
    void delete(ClassRoom classRoom);
}
