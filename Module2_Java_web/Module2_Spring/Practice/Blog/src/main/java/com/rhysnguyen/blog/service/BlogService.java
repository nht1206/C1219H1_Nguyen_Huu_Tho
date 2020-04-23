package com.rhysnguyen.blog.service;

import com.rhysnguyen.blog.entity.Blog;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface BlogService {
    public List<Blog> findAll();
    public Blog findById(Long id);
    public void save(Blog blog);
    public void remove(Long id);
}
