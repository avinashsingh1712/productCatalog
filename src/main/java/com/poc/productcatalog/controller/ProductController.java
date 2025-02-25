package com.poc.productcatalog.controller;
import com.poc.productcatalog.data.ProductRepository;
import com.poc.productcatalog.dto.Product;
import com.poc.productcatalog.service.FuzzySearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            product.setId(UUID.randomUUID().toString());
            productRepository.save(product);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding product: " + e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        return productRepository.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductsByName(@RequestParam String query) {

        //The fuzzySearch takes a list of product names, a search query, and a maximum allowed distance.
        // It returns a list of products that are within the specified distance from the search query.
        List<Product>  matchingProducts =  FuzzySearch.searchProducts(productRepository.findAll(), query, 2);
        return ResponseEntity.ok(matchingProducts);
    }

}
