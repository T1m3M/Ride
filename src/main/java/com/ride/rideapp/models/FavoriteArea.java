package com.ride.rideapp.models;

import org.springframework.stereotype.Component;

@Component
public class FavoriteArea extends GlobalArea{
    int driver_id;

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }
}
