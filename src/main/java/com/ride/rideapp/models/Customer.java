package com.ride.rideapp.models;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Customer extends User {
    private boolean account_status;
    private Date birthdate;
    private float balance;

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public boolean getAccount_status() {
        return account_status;
    }

    public void setAccount_status(boolean account_status) {
        this.account_status = account_status;
    }
}
