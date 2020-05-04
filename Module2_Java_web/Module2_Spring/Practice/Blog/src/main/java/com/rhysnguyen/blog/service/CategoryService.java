package com.rhysnguyen.blog.service;



import com.rhysnguyen.blog.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public List<Category> findAll();
    public Optional<Category> findById(Long id);
    public void save(Category category);
    public void remove(Long id);
}
