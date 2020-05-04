package com.codegym.blogpaging.service;

import com.codegym.blogpaging.dao.BlogRepository;
import com.codegym.blogpaging.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }


    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public Page<Blog> findAllByNameBlogContaining(String nameBlog, Pageable pageable) {
        return blogRepository.findAllByTitleContaining(nameBlog, pageable);
    }

    @Override
    public List<Blog> findAllByOrderByDatePostAsc(){
        return blogRepository.findAllByOrderByPostDateAsc();
    };
}
