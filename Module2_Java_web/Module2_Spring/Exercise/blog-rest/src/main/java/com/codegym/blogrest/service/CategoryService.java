package com.codegym.blogrest.service;

import java.util.List;
import java.util.Optional;

import com.codegym.blogrest.model.Category;

public interface CategoryService {
    public List<Category> findAll();
    public Optional<Category> findById(Long id);
    public void save(Category category);
    public void remove(Long id);
}
