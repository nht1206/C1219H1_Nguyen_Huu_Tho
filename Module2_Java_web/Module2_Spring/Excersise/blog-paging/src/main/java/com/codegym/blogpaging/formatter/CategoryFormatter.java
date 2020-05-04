package com.codegym.blogpaging.formatter;


import com.codegym.blogpaging.dao.CategoryRepository;
import com.codegym.blogpaging.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class CategoryFormatter implements Formatter<Optional<Category>> {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryFormatter(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Optional<Category> parse(String text, Locale locale) throws ParseException {
        return categoryRepository.findById(Long.parseLong(text));
    }

    @Override
    public String print(Optional<Category> object, Locale locale) {
        return "[" + object.get().getId() + ", " +object.get().getNameCategory() + "]";
    }
}