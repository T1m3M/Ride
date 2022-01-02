package com.ride.rideapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class Ride {
    @Id
    int id;

    String source, destination;
    int number_of_passengers;

    Timestamp start_time, end_time;
    int offer_id;
    boolean ride_status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumber_of_passengers() {
        return number_of_passengers;
    }

    public void setNumber_of_passengers(int number_of_passengers) {
        this.number_of_passengers = number_of_passengers;
    }

    public Timestamp getStart_time() {
        return start_time;
    }

    public void setStart_time(Timestamp start_time) {
        this.start_time = start_time;
    }

    public Timestamp getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Timestamp end_time) {
        this.end_time = end_time;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public boolean getRide_status() {
        return ride_status;
    }

    public void setRide_status(boolean ride_status) {
        this.ride_status = ride_status;
    }
}
