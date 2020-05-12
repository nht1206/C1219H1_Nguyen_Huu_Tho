package com.codegym.blogrest.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.codegym.blogrest.model.ApiError;
import com.codegym.blogrest.model.Category;
import com.codegym.blogrest.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    CategoryService categoryService;
    /**
     * @param categoryService the categoryService to set
     */
    @Autowired
    public void setCategoryService(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllCategories() {
        final List<Category> categories = categoryService.findAll();
        if (categories == null) {
            return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, "Category not found", ""), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/blog")
    public ResponseEntity<Object> getMethodName(@PathVariable final Long id) {
        final Category category = categoryService.findById(id).orElse(null);
        if (category != null) {
            return new ResponseEntity<>(category.getBlogs(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, "Category not found", ""), HttpStatus.NOT_FOUND);
    }

    @PostMapping(value="")
    public ResponseEntity<Object> createCategory(@RequestBody final Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
    
    
}