package services;

import models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);

    Product findByName(String name);

    List<Product> searchProducts(String keyword);
}
