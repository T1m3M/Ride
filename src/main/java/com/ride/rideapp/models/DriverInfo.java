package com.ride.rideapp.models;

public class DriverInfo {
    String username, mobile;
    float average_rating;
    boolean verification_status;
    int seats_number;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public float getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(float average_rating) {
        this.average_rating = average_rating;
    }

    public boolean setVerification_status() {
        return verification_status;
    }

    public void setVerification_status(boolean verification_status) {
        this.verification_status = verification_status;
    }

    public int getSeats_number() {
        return seats_number;
    }

    public void setSeats_number(int seats_number) {
        this.seats_number = seats_number;
    }
}
