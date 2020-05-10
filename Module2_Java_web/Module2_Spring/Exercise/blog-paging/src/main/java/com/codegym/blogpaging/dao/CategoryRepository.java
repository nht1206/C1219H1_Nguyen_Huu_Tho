package com.codegym.blogpaging.dao;

import com.codegym.blogpaging.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
