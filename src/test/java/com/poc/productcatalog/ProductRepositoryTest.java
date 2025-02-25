package com.poc.productcatalog;

import com.poc.productcatalog.data.ProductRepository;
import com.poc.productcatalog.dto.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
    }

    @Test
    void findAllReturnsAllProducts() {
        List<Product> products = productRepository.findAll();
        assertNotNull(products);
        assertFalse(products.isEmpty());
    }

    @Test
    void findByIdReturnsProductWhenIdExists() {
        Product product = new Product(getId(), "Test Product", "Test Category", "Test Description", 10.0, "Test Image URL");
        productRepository.save(product);

        Optional<Product> foundProduct = productRepository.findById(product.getId());
        assertTrue(foundProduct.isPresent());
        assertEquals(product.getId(), foundProduct.get().getId());
    }

    @Test
    void findByIdReturnsEmptyWhenIdDoesNotExist() {
        Optional<Product> foundProduct = productRepository.findById(getId());
        assertFalse(foundProduct.isPresent());
    }

    @Test
    void findByNameReturnsProductWhenNameExists() {
        Product product = new Product(getId(), "Test Product", "Test2 Category", "Test Description", 15.0, "Test Image URL");
        productRepository.save(product);

        Optional<Product> foundProduct = productRepository.findByName("Test Product");
        assertTrue(foundProduct.isPresent());
        assertEquals("Test Product", foundProduct.get().getName());
    }

    @Test
    void findByNameReturnsEmptyWhenNameDoesNotExist() {
        Optional<Product> foundProduct = productRepository.findByName("Nonexistent Product");
        assertFalse(foundProduct.isPresent());
    }

    @Test
    void saveAddsProductToRepository() {
        Product product = new Product(getId(), "New Product", "New Category", "New Description", 20.0, "New Image URL");
        productRepository.save(product);

        List<Product> products = productRepository.findAll();
        assertTrue(products.contains(product));
    }

    private static String getId() {
        return UUID.randomUUID().toString();
    }
}