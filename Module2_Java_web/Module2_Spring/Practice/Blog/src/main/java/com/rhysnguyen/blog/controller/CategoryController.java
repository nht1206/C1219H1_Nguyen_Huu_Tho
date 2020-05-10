package com.rhysnguyen.blog.controller;

import java.util.List;

import com.rhysnguyen.blog.entity.Blog;
import com.rhysnguyen.blog.entity.Category;
import com.rhysnguyen.blog.service.BlogService;
import com.rhysnguyen.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;
    @GetMapping
    public String home(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "category/home";
    }
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("category", new Category());
        return "category/create-form";
    }
    @PostMapping("/create")
    public String processCreate(Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/edit/{id}")
    public String blogEditingForm(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id).orElse(null);
        model.addAttribute("category", category);
        return "category/edit-form";
    }


    @PostMapping("/edit")
    public String processEditing(Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String processDeleting(@PathVariable Long id) {
        Category category = categoryService.findById(id).orElse(null);
        if (category != null) {
            List<Blog> blogs = category.getBlogs();
            for (Blog blog : blogs) {
                blog.setCategory(null);
                blogService.save(blog);
            }
            categoryService.remove(id);
        }
        return "redirect:/category";
    }
}
