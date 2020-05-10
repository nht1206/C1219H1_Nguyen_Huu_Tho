package com.codegym.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;

import com.codegym.shoppingcart.model.Product;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private List<Product> products;

    public ProductServiceImpl() {
        products = new ArrayList<>();
        products.add(new Product((long) 1, "Product 1", "Content 1", (float) 50000));
        products.add(new Product((long) 2, "Product 2", "Content 2", (float) 40000));
        products.add(new Product((long) 3, "Product 3", "Content 3", (float) 50000));
        products.add(new Product((long) 4, "Product 4", "Content 4", (float) 60000));
        products.add(new Product((long) 5, "Product 5", "Content 5", (float) 50000));
    }

    @Override
    public void addNewProduct(Product product) {
        products.add(product);
    }

    @Override
    public void deleteProduct(Long id) {
        for (Product product : products) {
            if (id.equals(product.getId())) {
                products.remove(product);
                return;
            }
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        for (Product product : products) {
            if (id.equals(product.getId())) {
                return product;
            }
        }
        return null;
    }
    
}