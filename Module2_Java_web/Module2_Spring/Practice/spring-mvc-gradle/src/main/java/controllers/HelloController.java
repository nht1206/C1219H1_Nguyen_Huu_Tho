package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HelloController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Rhys Nguyen");
        return "index";
    }
}
