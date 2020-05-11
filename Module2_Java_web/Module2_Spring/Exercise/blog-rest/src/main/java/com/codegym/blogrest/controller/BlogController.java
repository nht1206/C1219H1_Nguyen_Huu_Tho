package com.codegym.blogrest.controller;

import java.util.List;

import com.codegym.blogrest.model.Blog;
import com.codegym.blogrest.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    BlogService blogService;
    /**
     * @param blogService the blogService to set
     */
    @Autowired
    public void setBlogService(final BlogService blogService) {
        this.blogService = blogService;
    }
    @GetMapping("")
    public List<Blog> getAllBlogs() {
        return blogService.findAll();
    }
    @GetMapping(value="/{id}")
    public Blog getBlog(@PathVariable Long id) {
        return blogService.findById(id);
    }
    
}