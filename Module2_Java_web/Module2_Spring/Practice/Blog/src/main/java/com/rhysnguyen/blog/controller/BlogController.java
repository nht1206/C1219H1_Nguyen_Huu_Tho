package com.rhysnguyen.blog.controller;

import com.rhysnguyen.blog.entity.Blog;
import com.rhysnguyen.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;

@Controller
@RequestMapping("/blog-manager")
public class BlogController {
    BlogService blogService;

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("blogs", blogService.findAll());
        return "home";
    }

    @GetMapping("/create")
    public String blogCreatingForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "create-form";
    }

    @PostMapping("/create")
    public String processCreating(Blog blog) {
        blog.setPostDate(Date.valueOf(LocalDate.now()));
        blogService.save(blog);
        return "redirect:/blog-manager";
    }

    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog-detail";
    }

    @GetMapping("/edit/{id}")
    public String blogEditingForm(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "edit-form";
    }


    @PostMapping("/edit")
    public String processEditing(Blog blog) {
        blogService.save(blog);
        return "redirect:/blog-manager";
    }

    @GetMapping("/delete/{id}")
    public String processDeleting(@PathVariable Long id) {
        blogService.remove(id);
        return "redirect:/blog-manager";
    }
}
