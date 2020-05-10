package com.codegym.shoppingcart.controller;

import java.util.Optional;

import com.codegym.shoppingcart.model.Cart;
import com.codegym.shoppingcart.model.Product;
import com.codegym.shoppingcart.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@SessionAttributes("cart")
@RequestMapping("/")
public class ProductController {
    @Autowired
    ProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart() {
        return new Cart();
    }

    @GetMapping(value = "")
    public ModelAndView home() {
        return new ModelAndView("home", "products", productService.getAllProducts());
    }

    @GetMapping(value = "/view/{id}")
    public ModelAndView getMethodName(@PathVariable("id") Long id) {
        return new ModelAndView("view", "product", productService.getProductById(id));
    }

    @PostMapping(value = "/addToCart/{id}")
    public String addToCart(@PathVariable("id") Optional<Long> id, 
        RedirectAttributes redirectAttributes,
        @ModelAttribute("cart") Cart cart
    ) {
        if (!id.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "Can not add this product to your cart.");
            return "redirect:/";
        }
        cart.addToCart(productService.getProductById(id.get()));
        redirectAttributes.addFlashAttribute("message", "Add the product to your cart successfully.");
        return "redirect:/";
    }
    @GetMapping("/cart")
    public ModelAndView goToCart(@ModelAttribute("cart") Cart cart){
        return new ModelAndView("cart","list",cart.getCart());
    }
    @GetMapping("/cart/{id}")
    public ModelAndView removeProduct(@ModelAttribute("cart") Cart cart,@PathVariable("id") Long id){
        cart.removeProduct(productService.getProductById(id));
        return new ModelAndView("redirect:/cart");
    }
    
    @GetMapping(value="/updateCart/{id}/{quantity}")
    public String updateCart(@PathVariable("id") Long  id, @PathVariable("quantity") Integer quantity,
        @ModelAttribute("cart") Cart cart
    ) {
        Product product = productService.getProductById(id);
        if (product != null) {
            cart.getCart().put(product, quantity);
        }
        return "redirect:/cart";
    }
    

}