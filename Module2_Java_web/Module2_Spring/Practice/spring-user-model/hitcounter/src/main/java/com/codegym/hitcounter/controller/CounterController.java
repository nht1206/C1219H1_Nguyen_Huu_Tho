package com.codegym.hitcounter.controller;

import com.codegym.hitcounter.model.Counter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@SessionAttributes("counter")
public class CounterController {
    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }
    @GetMapping(value="/")
    public String get(@ModelAttribute("counter") Counter counter) {
        counter.increase();
        return new String("index");
    }

    @GetMapping(value="/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return new String("error");
    }
    
}