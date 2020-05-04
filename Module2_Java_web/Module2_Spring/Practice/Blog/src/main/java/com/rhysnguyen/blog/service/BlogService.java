package com.rhysnguyen.blog.service;

import com.rhysnguyen.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;


public interface BlogService {
    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
    Page<Blog> search(String title, Pageable pageable);
    Page<Blog> findByPostDate(Date postDate, Pageable pageable);
}
