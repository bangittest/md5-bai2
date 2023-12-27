package com.ra.model.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "classroom")
public class ClassRoom {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "classroom_name")
    private String classRoomName;
    @Column(name = "status")
    private Boolean status =true;
    @OneToMany(mappedBy = "classRoom")
    private Set<Student> students;


    public ClassRoom() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
