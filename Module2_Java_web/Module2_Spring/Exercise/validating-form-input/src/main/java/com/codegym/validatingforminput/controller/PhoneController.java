package com.codegym.validatingforminput.controller;

import com.codegym.validatingforminput.model.PhoneNumber;
import com.codegym.validatingforminput.model.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Locale;

@Controller
public class PhoneController {
    @Autowired
    PhoneNumberValidator phoneNumberValidator;
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(phoneNumberValidator);
    }
    @GetMapping("/")
    public String showForm(Model model, Locale locale){
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "phone/index";
    }
    @PostMapping("/")
    public String checkValidation (@ModelAttribute("phoneNumber") @Validated PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "phone/index";
        }
        else {
            model.addAttribute("number", phoneNumber.getNumber());
            return "phone/result";
        }
    }
}
