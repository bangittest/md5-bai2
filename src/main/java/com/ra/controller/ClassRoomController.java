package com.ra.controller;

import com.ra.model.entity.ClassRoom;
import com.ra.model.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ClassRoomController {
    @Autowired
    ClassRoomService classRoomService;
    @GetMapping("/classroom")
    public String classroom(Model model){
        List<ClassRoom>classRoomList=classRoomService.findAll();
        model.addAttribute("classroom",classRoomList);
        return "classroom";
    }
    @GetMapping("add-classroom")
    public String add(Model model){
        ClassRoom classRoom=new ClassRoom();
        model.addAttribute("classroom",classRoom);
        return "add-classroom";
    }
    @PostMapping("create-classroom")
    public String create(@ModelAttribute("classroom") ClassRoom classRoom){
       if (classRoom!=null){
           classRoomService.save(classRoom);
           return "redirect:/classroom";
       }else {
           return "redirect:/add-classroom";
       }

    }

    @GetMapping("edit-classroom/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        ClassRoom classRoom=classRoomService.findById(id);
        model.addAttribute("classroom",classRoom);
        return "edit-classroom";
    }

    @PostMapping("update-classroom")
    public String update(@ModelAttribute("classroom") ClassRoom classRoom){
       if (classRoom!=null){
           classRoomService.update(classRoom);
           return "redirect:/classroom";
        }else {
            return "redirect:/edit-classroom/"+classRoom.getId();
        }

    }
}
