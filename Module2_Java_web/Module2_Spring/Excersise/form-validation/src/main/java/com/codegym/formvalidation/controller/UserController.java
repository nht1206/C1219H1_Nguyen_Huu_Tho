package com.codegym.formvalidation.controller;

import com.codegym.formvalidation.entity.User;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Controller
@RequestMapping("/")
public class UserController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(       Date.class,
                new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
    }
    @GetMapping
    public String home(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
    @PostMapping
    public String processSubmit(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "index";
        model.addAttribute("user", user);
        return "result";
    }
}
