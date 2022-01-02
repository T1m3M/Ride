package com.ride.rideapp.models;

import org.springframework.data.annotation.Id;

public abstract class GlobalArea {
    @Id
    int id;
    String area_name;

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
}
