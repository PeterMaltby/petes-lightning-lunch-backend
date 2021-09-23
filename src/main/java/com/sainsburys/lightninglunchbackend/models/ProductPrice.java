package com.sainsburys.lightninglunchbackend.models;

import java.math.BigDecimal;

public class ProductPrice {
    private BigDecimal now;
    private boolean mealDeal;
    private String flashText;

    public BigDecimal getNow() {
        return now;
    }

    public void setNow(BigDecimal now) {
        this.now = now;
    }

    public boolean isMealDeal() {
        return mealDeal;
    }

    public void setMealDeal(boolean mealDeal) {
        this.mealDeal = mealDeal;
    }

    public String getFlashText() {
        return flashText;
    }

    public void setFlashText(String flashText) {
        this.flashText = flashText;
    }
}
