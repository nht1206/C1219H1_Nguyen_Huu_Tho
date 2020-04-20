package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CondimentController {
    @RequestMapping("/")
    public String home(Model model){
        return "save";
    }
    @PostMapping("/save")
    public ModelAndView save(@RequestParam(value = "condiment") String[] condiments, Model model){
        model.addAttribute("message","Your Choices");
        ModelAndView modelAndView = new ModelAndView("save");
        modelAndView.addObject("condiments",condiments);
        return modelAndView;
    }
}
