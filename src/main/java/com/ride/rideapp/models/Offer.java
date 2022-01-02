package com.ride.rideapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Offer {
    @Id
    int id;

    int ride_id, driver_id;
    int price;

    Timestamp offer_time, accept_time;
    boolean offer_status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRide_id() {
        return ride_id;
    }

    public void setRide_id(int ride_id) {
        this.ride_id = ride_id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Timestamp getOffer_time() {
        return offer_time;
    }

    public void setOffer_time(Timestamp offer_time) {
        this.offer_time = offer_time;
    }

    public Timestamp getAccept_time() {
        return accept_time;
    }

    public void setAccept_time(Timestamp accept_time) {
        this.accept_time = accept_time;
    }

    public boolean getOffer_status() {
        return offer_status;
    }

    public void setOffer_status(boolean offer_status) {
        this.offer_status = offer_status;
    }
}
