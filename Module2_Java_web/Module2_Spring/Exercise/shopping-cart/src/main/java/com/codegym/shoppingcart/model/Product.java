package com.codegym.shoppingcart.model;

public class Product {
    private Long id;
    private String productName;
    private String content;
    private Float price;

    public Product() {
    }

    public Product(Long id, String productName, String content, Float price) {
        this.id = id;
        this.content = content;
        this.price = price;
        this.productName = productName;
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    

    
}