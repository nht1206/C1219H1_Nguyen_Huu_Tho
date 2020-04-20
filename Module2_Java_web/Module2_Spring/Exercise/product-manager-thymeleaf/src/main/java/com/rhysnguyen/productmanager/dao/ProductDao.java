package com.rhysnguyen.productmanager.dao;

import com.rhysnguyen.productmanager.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao {
    private static List<Product> products;
    static {
        products = new ArrayList<>();
        products.add(new Product("Product 1", 30000, "Description to product 1", "Producer 1"));
        products.add(new Product("Product 2", 20000, "Description to product 2", "Producer 2"));
        products.add(new Product("Product 3", 40000, "Description to product 3", "Producer 3"));
        products.add(new Product("Product 4", 50000, "Description to product 4", "Producer 4"));
        products.add(new Product("Product 5", 20000, "Description to product 5", "Producer 5"));
    }
    public List<Product> getProducts() {
        return products;
    }
    public void save(Product product) {
        products.add(product);
    }
    public void remove(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return;
            }
        }
    }
    public void update(Product product) {
        for (Product p : products) {
            if (product.getId() == p.getId()) {
                products.add(products.indexOf(p), product);
                return;
            }
        }
    }
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
