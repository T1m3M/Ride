package com.ride.rideapp.models;

import org.springframework.stereotype.Component;

@Component
public class Customer extends User {
    private boolean account_status;

    @Override
    public Customer login(String mobile, String password) {
        return loginRepo.loginCustomer(mobile, password);
    }

    @Override
    public Customer register(String username, String mobile, String password) {
        return registerRepo.registerCustomer(username, mobile, password);
    }

    public boolean getAccount_status() {
        return account_status;
    }

    public void setAccount_status(boolean account_status) {
        this.account_status = account_status;
    }
}
