//package com.ra.controller;
//
//import com.ra.model.entity.User;
//import com.ra.model.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import java.util.List;
//
//@Controller
//public class UserController {
//    @Autowired
//    UserService userService;
//    @GetMapping("/user")
//    public String user(Model model){
//        List<User> users=userService.findAll();
//        model.addAttribute("users",users);
//        return "users";
//    }
//    @GetMapping("/user-add")
//    public String add(Model model){
//        User user=new User();
//        model.addAttribute("user",user);
//        return "add-user";
//    }
//    @PostMapping("user-create")
//    public String create(@ModelAttribute("user") User user){
//        if (userService.save(user)){
//            return "redirect:/user";
//        }
//        return "redirect:/user-add";
//    }
//
//    @GetMapping("user-edit/{id}")
//    public String edit(@PathVariable("id") Integer id,Model model){
//        User user=userService.findById(id);
//        model.addAttribute("user",user);
//        return "edit-user";
//    }
//    @PostMapping("user-update")
//    public String update(@ModelAttribute("user") User user){
//        if (userService.update(user)){
//            return "redirect:/user";
//        }
//        return "redirect:/user-edit/"+user.getId();
//    }
//
//    @GetMapping("user-delete/{id}")
//    public String delete(@PathVariable("id") Integer id){
//        userService.delete(id);
//        return "redirect:/user";
//    }
//}
