package com.codegym.blogrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codegym.blogrest.model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
