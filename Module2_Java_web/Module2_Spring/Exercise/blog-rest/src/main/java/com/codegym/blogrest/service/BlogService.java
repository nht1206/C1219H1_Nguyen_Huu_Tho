package com.codegym.blogrest.service;

import java.util.List;

import com.codegym.blogrest.model.Blog;


public interface BlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
}
