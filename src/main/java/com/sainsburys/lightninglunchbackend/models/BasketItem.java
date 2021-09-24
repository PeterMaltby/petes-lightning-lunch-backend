package com.sainsburys.lightninglunchbackend.models;

public class BasketItem {



    final private Product product;

    private Integer qauntity;

    public BasketItem(Product product, Integer qauntity) {
        this.product = product;
        this.qauntity = qauntity;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQauntity() {
        return qauntity;
    }

    public void addQauntity(Integer qauntity) {
        this.qauntity += qauntity;
    }
}
