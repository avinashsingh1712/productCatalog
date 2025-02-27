package com.poc.productcatalog.controller;
import com.poc.productcatalog.data.ProductRepository;
import com.poc.productcatalog.dto.Product;
import com.poc.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        try {
            product.setId(UUID.randomUUID().toString());
            productService.save(product);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding product: " + e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProductsByName(@RequestParam String query, int maxDistance) {

        //The fuzzySearch takes a list of product names, a search query, and a maximum allowed distance.
        // It returns a list of products that are within the specified distance from the search query.
        List<Product>  matchingProducts =  productService.searchProducts(productService.findAll(), query, maxDistance);
        return ResponseEntity.ok(matchingProducts);
    }

}
