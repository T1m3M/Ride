package com.ride.rideapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class Discount {
    @Id
    int id;

    String area_name;
    float rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
