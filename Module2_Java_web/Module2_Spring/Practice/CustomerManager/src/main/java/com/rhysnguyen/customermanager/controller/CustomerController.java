package com.rhysnguyen.customermanager.controller;

import com.rhysnguyen.customermanager.entity.Customer;
import com.rhysnguyen.customermanager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "customer-home";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-create";
    }

    @PostMapping("/create")
    public String processCreate(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer-edit";
    }
    @PostMapping("/edit")
    public String processEdit(Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Edit customer successfully!");
        return "redirect:/customer";
    }
    @GetMapping("/delete/{id}")
    public String processDelete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message", "Delete customer successfully!");
        return "redirect:/customer";
    }
}
