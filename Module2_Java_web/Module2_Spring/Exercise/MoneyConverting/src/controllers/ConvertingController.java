package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertingController {
    @GetMapping("/converting")
    public String showConvertingForm(@RequestParam String usd, @RequestParam String rate, Model model) {
        float result = Float.parseFloat(usd) * Float.parseFloat(rate);
        model.addAttribute("result", result);
        return "show-result";
    }
}
