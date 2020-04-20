package com.rhysnguyen.productmanager.controller;

import com.rhysnguyen.productmanager.dao.ProductDao;
import com.rhysnguyen.productmanager.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ProductController {
    @Autowired
    ProductDao productDao;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productDao.getProducts());
        return "home";
    }
    @GetMapping("/product/create")
    public String createForm(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/product/create")
    public String createProcess(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int)(Math.random() * 10000));
        productDao.save(product);
        redirectAttributes.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/delete")
    public String deleteForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productDao.findById(id));
        return "delete";
    }
    @PostMapping("/product/{id}/delete")
    public String deleteProcess(@PathVariable int id, RedirectAttributes redirectAttributes) {
        productDao.remove(id);
        redirectAttributes.addFlashAttribute("success", "Deleted product successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/update")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productDao.findById(id));
        return "update";
    }
    @PostMapping("/product/{id}/update")
    public String updateProcess(Product product, RedirectAttributes redirectAttributes) {
        productDao.update(product);
        redirectAttributes.addFlashAttribute("success", "Updated product successfully!");
        return "redirect:/";
    }
}
