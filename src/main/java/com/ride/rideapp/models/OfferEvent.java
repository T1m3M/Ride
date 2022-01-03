package com.ride.rideapp.models;

import org.springframework.stereotype.Component;

@Component
public class OfferEvent extends Event {

    String captain_name;
    float price;

    public String getCaptain_name() {
        return captain_name;
    }

    public void setCaptain_name(String captain_name) {
        this.captain_name = captain_name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
