package com.rhysnguyen.blog.dao;

import com.rhysnguyen.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
