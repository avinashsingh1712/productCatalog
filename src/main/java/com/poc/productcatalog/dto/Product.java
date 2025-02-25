package com.poc.productcatalog.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String id;
    private String name;
    private String category;
    private String description;
    private double price;
    private String imageUrl;

    public Product(String id, String name, String category, String description, double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
