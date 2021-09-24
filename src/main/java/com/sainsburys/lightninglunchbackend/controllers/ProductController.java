package com.sainsburys.lightninglunchbackend.controllers;

import com.sainsburys.lightninglunchbackend.exceptions.ProductNotFoundException;
import com.sainsburys.lightninglunchbackend.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    /*@GetMapping("helloWorld")
    public ResponseEntity<?> sayHello() {
        return ResponseEntity.ok("Hi there!");
    }*/

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("{productId}")
    public ResponseEntity<?> getProductDetails(@PathVariable("productId") String productId) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.getProduct(productId));
    }
}
