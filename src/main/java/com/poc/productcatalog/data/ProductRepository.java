package com.poc.productcatalog.data;

import com.poc.productcatalog.dto.Product;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class ProductRepository {

    private final List<Product> products = new CopyOnWriteArrayList<>(MockData.getMockProducts());

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(String id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public Optional<Product> findByName(String name) {
        return products.stream().filter(product -> product.getName().equals(name)).findFirst();
    }

    public void save(Product product) {
        products.add(product);
    }
}
