package com.ra.controller;

import com.ra.model.entity.ClassRoom;
import com.ra.model.entity.Student;
import com.ra.model.service.ClassRoomService;
import com.ra.model.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    ClassRoomService classRoomService;
    @GetMapping("/student")
    public String student(Model model){
        List<Student> studentList=studentService.findAll();
        model.addAttribute("student",studentList);
        return "student";
    }

    @GetMapping("/add-student")
    public String add(Model model){
        Student student=new Student();
        model.addAttribute("student",student);
        List<ClassRoom>classRoomList=classRoomService.findAll();
        model.addAttribute("classroom",classRoomList);
        return "add-student";
    }
    @PostMapping("/create-student")
    public String create(@ModelAttribute("student") Student student){
       if (student!=null){
           studentService.save(student);
           return "redirect:/student";
       }
        return "redirect:/add-student";
    }
    @GetMapping("edit-student/{id}")
    public String edit(@PathVariable("id")Integer id,Model model){
        Student student=studentService.findById(id);
        model.addAttribute("student",student);
        List<ClassRoom>classRoomList=classRoomService.findAll();
        model.addAttribute("classroom",classRoomList);
        return "edit-student";
    }
    @PostMapping("update-student")
    public String update(@ModelAttribute("student") Student student){
        if (student!=null){
            studentService.update(student);
            return "redirect:/student";
        }
        return "redirect:/edit-student/"+student.getId();
    }
}
