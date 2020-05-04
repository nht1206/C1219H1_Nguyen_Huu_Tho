package com.rhysnguyen.blog.dao;

import com.rhysnguyen.blog.entity.Blog;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;

public interface BlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findByTitleContaining(String title, Pageable pageable);
    Page<Blog> findByPostDate(Date postDate, Pageable pageable);
}
