package com.poc.productcatalog.data;

import com.poc.productcatalog.dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class MockData {

    public static List<Product> getMockProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("0dc269ae-08b2-4599-b0ff-912b2d55ce5a", "NormalPhone", "Electronics", "Normal Phone", 999.99, "https://example.com/images/normalPhone.jpg"));
        products.add(new Product("0dc269ae-08b2-4599-b0ff-912b2d55ce5b", "Smartphone", "Electronics", "Latest model smartphone", 799.99, "https://example.com/images/smartphone.jpg"));
        products.add(new Product("0dc269ae-08b2-4599-b0ff-912b2d55ce5c", "Headphones", "Accessories", "Noise-cancelling headphones", 199.99, "https://example.com/images/headphones.jpg"));
        products.add(new Product("0dc269ae-08b2-4599-b0ff-912b2d55ce5d", "iPhone", "Home Electronics", "Advance Phone", 89.99, "https://example.com/images/iPhone.jpg"));
        products.add(new Product("0dc269ae-08b2-4599-b0ff-912b2d55ce5e", "demoPhone", "Electronics", "Demp Phone", 129.99, "https://example.com/images/demoPhone.jpg"));

        return products;
    }
}
