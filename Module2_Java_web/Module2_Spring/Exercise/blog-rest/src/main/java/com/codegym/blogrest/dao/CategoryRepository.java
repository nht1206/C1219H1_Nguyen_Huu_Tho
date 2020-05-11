package com.codegym.blogrest.dao;

import com.codegym.blogrest.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
}
