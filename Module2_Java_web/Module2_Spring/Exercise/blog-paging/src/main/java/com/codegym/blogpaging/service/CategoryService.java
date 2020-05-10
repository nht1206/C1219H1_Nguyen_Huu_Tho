package com.codegym.blogpaging.service;

import com.codegym.blogpaging.entity.Category;

import java.util.Optional;

public interface CategoryService {
    Iterable<Category> findAll();


    Optional<Category> findById(Long id);

    Category save(Category category);

    void delete(Category category);
}
