package com.poc.productcatalog.service;

import com.poc.productcatalog.data.ProductRepository;
import com.poc.productcatalog.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /**
     * Finds all products from the producs that are within the specified distance from the search query.
     *
     * @param productList  the list of products to search
     * @param query  the search text
     * @param maxDistance the maximum allowed distance
     * @return a list of products that are within the specified distance from the search term
     */
    public List<Product> searchProducts(List<Product> productList,String query, int maxDistance) {
        List<Product> results = new ArrayList<>();
        for (Product product : productList) {
            int distance = findMatching(query, product.getName());
            if (distance <= maxDistance) {
                results.add(product);
            }
        }
        return results;
    }

    /**
     * Calculates the Levenshtein distance between two strings.
     * The Levenshtein distance is a measure of the difference between two sequences.     *
     *
     * @param query the search string
     * @param productName the second string
     * @return the Levenshtein distance between the two strings
     */
    private int findMatching(String query, String productName) {
        int qLength = query.length();
        int pLength = productName.length();
        int[][] pArray = new int[qLength + 1][pLength + 1];

        /**
         * Initializes the first row and column of the pArray array.
         * The first row and column represent the cost of converting an empty string to the other string.
         */
        for (int i = 0; i <= qLength; i++) {
            pArray[i][0] = i;
        }
        for (int j = 0; j <= pLength; j++) {
            pArray[0][j] = j;
        }

        for (int i = 1; i <= qLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                int cost = (query.charAt(i - 1) == productName.charAt(j - 1)) ? 0 : 1;
                pArray[i][j] = Math.min(Math.min(pArray[i - 1][j] + 1, pArray[i][j - 1] + 1), pArray[i - 1][j - 1] + cost);
            }
        }
        return pArray[qLength][pLength];
    }
}
