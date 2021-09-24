package com.sainsburys.lightninglunchbackend.controllers;

import com.sainsburys.lightninglunchbackend.models.Basket;
import com.sainsburys.lightninglunchbackend.models.BasketRequest;
import com.sainsburys.lightninglunchbackend.service.BasketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("baskets")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("{basketId}")
    public Basket getBasketDetails(@PathVariable("basketId") String basketId) {
        return basketService.getBasket(basketId);
    }

    @PostMapping
    public Basket creatBasket(@RequestBody BasketRequest basketRequest) {
        return basketService.createBasket(basketRequest);
    }

    @PutMapping("{basketId}")
    public Basket addToBasket(@PathVariable("basketId") String basketId, @RequestBody BasketRequest basketRequest) {
        return basketService.addToBasket(basketId, basketRequest);
    }
}
