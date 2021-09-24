package com.sainsburys.lightninglunchbackend.models;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private String id;

    private List<BasketItem> basketItems = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addProduct(Product product, int qauntity) {
        boolean found = false;

        for (BasketItem basketItem : basketItems) {
            if (product.getId().equals(basketItem.getProduct().getId())) {
                basketItem.addQauntity(qauntity);
                found = true;
                break;
            }
        }
        if (!found) basketItems.add(new BasketItem(product,qauntity));
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

}
