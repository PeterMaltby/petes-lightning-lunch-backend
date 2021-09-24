package com.sainsburys.lightninglunchbackend.service;

import com.sainsburys.lightninglunchbackend.exceptions.ProductNotFoundException;
import com.sainsburys.lightninglunchbackend.models.Basket;
import com.sainsburys.lightninglunchbackend.models.BasketRequest;
import com.sainsburys.lightninglunchbackend.models.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class BasketService {

    private final ProductService productService;

    public BasketService(ProductService productService) {
        this.productService = productService;
    }

    private final Map<String, Basket> baskets = new HashMap<>();

    public Basket getBasket(String basketId) {
        return baskets.get(basketId);
    }

    public Basket addToBasket(String basketId, BasketRequest basketRequest) {
        Basket basket = baskets.get(basketId);

        try {
            Product product = productService.getProduct(basketRequest.getProductId());
            basket.addProduct(product, basketRequest.getQauntity());
            return basket;
        } catch (ProductNotFoundException e) {
            System.out.println("PRODUCT NOT FOUND!");
            return null;
        }
    }

    public Basket createBasket(BasketRequest basketRequest) {
        Basket basket = new Basket();
        basket.setId(UUID.randomUUID().toString());
        baskets.put(basket.getId(), basket);
        return addToBasket(basket.getId(), basketRequest);
    }
}
