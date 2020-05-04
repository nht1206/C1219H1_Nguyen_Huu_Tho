package com.rhysnguyen.blog.controller;

import com.rhysnguyen.blog.entity.Blog;
import com.rhysnguyen.blog.entity.Category;
import com.rhysnguyen.blog.service.BlogService;
import com.rhysnguyen.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    private BlogService blogService;
    private CategoryService categoryService;

    @Autowired
    public void setBlogService(BlogService blogService) {
        this.blogService = blogService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ModelAttribute("categories")
    private List<Category> getCategories() {
        return categoryService.findAll();
    }

    @GetMapping
    public String home(
            Model model,
            @PageableDefault(value = 2) Pageable pageable,
            @RequestParam("title") Optional<String> title,
            @RequestParam("sort") Optional<String> sort
    ) {
        Page<Blog> blogPage;
        if (title.isPresent()) {
            blogPage = blogService.search(title.get(), pageable);
        } else {
            blogPage = blogService.findAll(pageable);
        }
        model.addAttribute("blogs", blogPage);
        model.addAttribute("title", title.orElse(""));
        model.addAttribute("sort", sort.orElse(""));
        return "blog/home";
    }

    @GetMapping("/create")
    public String blogCreatingForm(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create-form";
    }

    @PostMapping("/create")
    public String processCreating(Blog blog) {
        blog.setPostDate(Date.valueOf(LocalDate.now()));
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/view/{id}")
    public String viewBlog(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/blog-detail";
    }

    @GetMapping("/edit/{id}")
    public String blogEditingForm(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "blog/edit-form";
    }


    @PostMapping("/edit")
    public String processEditing(Blog blog) {
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete/{id}")
    public String processDeleting(@PathVariable Long id) {
        blogService.remove(id);
        return "redirect:/blog";
    }
}
