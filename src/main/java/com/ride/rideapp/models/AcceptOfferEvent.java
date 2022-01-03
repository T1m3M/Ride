package com.ride.rideapp.models;

import org.springframework.stereotype.Component;

@Component
public class AcceptOfferEvent extends Event {
    String user_name;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
