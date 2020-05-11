package com.codegym.blogrest.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.codegym.blogrest.dao.CategoryRepository;
import com.codegym.blogrest.model.Category;
import com.codegym.blogrest.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    CategoryService categoryService;
    /**
     * @param categoryService the categoryService to set
     */
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping(value="")
    public List<Category> getAllCategories(@RequestParam String param) {
        return new SomeData();
    }
    
}