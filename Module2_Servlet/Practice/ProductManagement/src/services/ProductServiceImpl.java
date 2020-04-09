package services;

import dao.ProductDao;
import models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private List<Product> products;

    private ProductDao productDao;

    public ProductServiceImpl() {
        productDao = new ProductDao();
        products = productDao.getAllProducts();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
        productDao.save(product);
    }

    @Override
    public Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }

    @Override
    public void update(Product product) {
        int id = -1;
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                id = products.indexOf(p);
            }
        }
        if (id != -1) {
            products.set(id, product);
            productDao.update(product);
        }
    }

    @Override
    public void remove(int id) {
        products.removeIf(p -> p.getId() == id);
        productDao.delete(id);
    }

    @Override
    public Product findByName(String name) {
        for (Product p : products) {
            if (p.getName().equals(name))
                return p;
        }
        return null;
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        List<Product> productList = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().contains(keyword))
                productList.add(p);

        }
        return productList;
    }
}
