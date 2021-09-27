package com.sainsburys.lightninglunchbackend.controllers;

import com.sainsburys.lightninglunchbackend.exceptions.ProductNotFoundException;
import com.sainsburys.lightninglunchbackend.service.ProductService;
import com.sainsburys.lightninglunchbackend.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
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


    @RequestMapping
    public ResponseEntity<?> getAllProductDetails() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
