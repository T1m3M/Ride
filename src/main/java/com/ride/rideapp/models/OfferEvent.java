package com.ride.rideapp.models;

import org.springframework.stereotype.Component;

@Component
public class OfferEvent extends Event {
    String captain_name;
    String user_name;

    public String getCaptain_name() {
        return captain_name;
    }

    public void setCaptain_name(String captain_name) {
        this.captain_name = captain_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
