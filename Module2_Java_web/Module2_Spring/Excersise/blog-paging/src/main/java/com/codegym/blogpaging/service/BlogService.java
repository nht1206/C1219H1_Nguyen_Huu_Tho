package com.codegym.blogpaging.service;

import com.codegym.blogpaging.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(Long id);

    Blog save(Blog blog);

    void delete(Blog blog);

    Page<Blog> findAllByNameBlogContaining(String nameBlog, Pageable pageable);

    List<Blog> findAllByOrderByDatePostAsc();
}
