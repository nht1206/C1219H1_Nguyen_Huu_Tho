package com.codegym.blogrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.codegym.blogrest.dao.BlogRepository;
import com.codegym.blogrest.model.Blog;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }


    @Override
    public Blog findById(Long id) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        return blogOptional.orElse(null);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }
}
