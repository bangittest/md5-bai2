package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.service.CategoryService;
import com.ra.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/product")
    public String product(Model model){
        List<Product> productList=productService.findAll();
        model.addAttribute("product",productList);
        return "product";
    }
    @GetMapping("/add-product")
    public String add(Model model){
        Product product=new Product();
        List<Category> categoryList=categoryService.findAll();
        model.addAttribute("product",product);
        model.addAttribute("categoryList",categoryList);
        return "add-product";
    }

    @PostMapping("/create-product")
    public String create(@ModelAttribute("product") Product product){
        if (productService.save(product)){
            return "redirect:/product";
        }
        return "redirect:/add-product";
    }

    @GetMapping("/edit-product/{id}")
    public String edit(@PathVariable("id") Integer id,Model model){
        Product product=productService.findById(id);
        model.addAttribute("product",product);
        List<Category> categoryList=categoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "edit-product";
    }
    @PostMapping("update-product")
    public String update(@ModelAttribute("product") Product product){
        if (productService.update(product)){
            return "redirect:/product";
        }
        return "redirect:/edit-product/"+product.getId();
    }
}
