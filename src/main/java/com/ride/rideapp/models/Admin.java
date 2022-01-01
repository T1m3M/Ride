package com.ride.rideapp.models;

import org.springframework.stereotype.Component;

@Component
public class Admin extends User {

    @Override
    public Admin login(String mobile, String password) {
        return loginRepo.loginAdmin(mobile, password);
    }

    @Override
    public Admin register(String username, String mobile, String password) {
        return registerRepo.registerAdmin(username, mobile, password);
    }
}
