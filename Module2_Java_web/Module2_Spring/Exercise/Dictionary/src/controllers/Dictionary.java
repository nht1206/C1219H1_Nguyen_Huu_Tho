package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Dictionary {
    private static Map<String, String> dictionary;
    static {
        dictionary = new HashMap<>();
        dictionary.put("hello", "xin chao");
        dictionary.put("hoodbye", "tam biet");
        dictionary.put("go", "di");
        dictionary.put("run", "chay");
    }

    @GetMapping(value = "/dictionary")
    public String showResult(@RequestParam String keyword, Model model) {
        String result = dictionary.get(keyword);
        if (result != null) {
            model.addAttribute("result", result);
        }
        return "dictionary";
    }
}
