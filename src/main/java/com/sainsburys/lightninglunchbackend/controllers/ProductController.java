package com.sainsburys.lightninglunchbackend.controllers;

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

    @GetMapping("{productId}")
    public ResponseEntity<?> getProductDetails(@PathVariable("productId") String productId) {
        return ResponseEntity.ok(productId);
    }
}
