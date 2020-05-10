package com.codegym.shoppingcart.service;

import java.util.List;

import com.codegym.shoppingcart.model.Product;

public interface ProductService {
    void addNewProduct(Product product);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
    Product getProductById(Long id);
}