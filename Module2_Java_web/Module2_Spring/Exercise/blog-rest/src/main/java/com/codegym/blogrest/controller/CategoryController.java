package com.codegym.blogrest.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.codegym.blogrest.exception.CategoryNotFoundException;
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
    public ResponseEntity<Object> getAllCategories() throws CategoryNotFoundException {
        final List<Category> categories = categoryService.findAll();
        if (categories == null) {
            throw new CategoryNotFoundException("Category not found.");
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Object> getCategory(@PathVariable final Long id) throws CategoryNotFoundException {
        final Category category = categoryService.findById(id).orElse(null);
        if (category == null) {
            throw new CategoryNotFoundException("Category not found.");
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    

    @GetMapping(value = "/{id}/blog")
    public ResponseEntity<Object> getMethodName(@PathVariable final Long id) throws CategoryNotFoundException {
        final Category category = categoryService.findById(id).orElse(null);
        if (category == null) {
            throw new CategoryNotFoundException("Category not found.");
        }

        return new ResponseEntity<>(category.getBlogs(), HttpStatus.OK);
    }

    @PostMapping(value="")
    public ResponseEntity<Object> createCategory(@RequestBody final Category category) {
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
    
    
}