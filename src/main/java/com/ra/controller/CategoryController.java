package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/category")
    public String category(Model model){
        List<Category> categoryList=categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "home";
    }
    @GetMapping("add")
    public String add(Model model){
        Category category=new Category();
        model.addAttribute("category",category);
        return "add-category";
    }
    @PostMapping("create")
    public String create(@ModelAttribute("category") Category category){
        if (categoryService.save(category)){
            return "redirect:/category";
        }
        return "redirect:/add";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        Category category=categoryService.findById(id);
        model.addAttribute("category", category);
        return "edit";
    }
    @PostMapping("update")
    public String update( @ModelAttribute("category") Category category){
        Category category1=categoryService.findById(category.getId());
        if (categoryService.update(category)){
            return "redirect:/category";
        }
       return "redirect:/edit/"+category1.getId();
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        categoryService.delete(id);
        return "redirect:/category";
    }

}
