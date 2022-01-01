package com.ride.rideapp.models;

public class Admin extends User {


    public User login(String mobile, String password) {
        return loginRepo.loginAdmin(mobile, password);
    }
}
