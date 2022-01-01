package com.ride.rideapp.models;

import org.springframework.stereotype.Component;

@Component
public class Customer extends User {
    private boolean account_status;

    public boolean getAccount_status() {
        return account_status;
    }

    public void setAccount_status(boolean account_status) {
        this.account_status = account_status;
    }
}
