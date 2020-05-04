package com.codegym.blogpaging.dao;

import com.codegym.blogpaging.entity.Blog;
import com.codegym.blogpaging.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Iterable<Blog> findAllByCategory(Category category);
    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    List<Blog> findAllByOrderByPostDateAsc();
}
