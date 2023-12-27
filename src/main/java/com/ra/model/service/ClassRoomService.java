package com.ra.model.service;

import com.ra.model.entity.ClassRoom;

import java.util.List;

public interface ClassRoomService {
    List<ClassRoom> findAll();
    boolean save(ClassRoom classRoom);
    boolean update(ClassRoom classRoom);
    ClassRoom findById(Integer id);
    void delete(ClassRoom classRoom);
}
