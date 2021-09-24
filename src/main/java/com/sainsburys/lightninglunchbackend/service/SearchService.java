package com.sainsburys.lightninglunchbackend.service;

import com.sainsburys.lightninglunchbackend.models.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchService {

    private final ProductService productService;

    public SearchService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> searchProducts(String searchterm) {

        List<Product> allProducts = productService.getAllProducts();
        List<Product> selectedProducts = new ArrayList<Product>();

        for (Product product : allProducts) {
            if (product.getId().equals(searchterm)) {
                selectedProducts.add(product);
                continue;
            }
            if (product.getType().equalsIgnoreCase(searchterm)) {
                selectedProducts.add(product);
                continue;
            }
            if (product.getAttributes().getName().equalsIgnoreCase(searchterm)) {
                selectedProducts.add(product);
                continue;
            }
            if (product.getAttributes().getBrand().equalsIgnoreCase(searchterm)) {
                selectedProducts.add(product);
                continue;
            }
            if (product.getAttributes().getDescription().toLowerCase().contains(searchterm.toLowerCase())) {
                selectedProducts.add(product);
                continue;
            }
        }

        return selectedProducts;
    }
}
