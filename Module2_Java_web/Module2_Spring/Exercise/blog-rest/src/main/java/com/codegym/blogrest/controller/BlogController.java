package com.codegym.blogrest.controller;

import java.sql.Date;

import com.codegym.blogrest.model.ApiError;
import com.codegym.blogrest.model.Blog;
import com.codegym.blogrest.service.BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/blog")
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
    public ResponseEntity<Object> getAllBlogs() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Object> getBlog(@PathVariable final Long id) {
        final Blog blog = blogService.findById(id);
        if (blog == null) {
            return  new ResponseEntity<>(new ApiError(HttpStatus.NOT_FOUND, "Blog not found", "") , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping(value="")
    public ResponseEntity<Object> createBlog(@RequestBody Blog blog) {
        blog.setPostDate(new Date(System.currentTimeMillis()));
        blogService.save(blog);
        return new ResponseEntity<>(blogService.findById(blog.getId()), HttpStatus.OK);
    }
    
    
}