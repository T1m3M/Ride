package com.ride.rideapp.models;

import org.springframework.stereotype.Component;

@Component
public class Area extends GlobalArea {
    float discount;

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
