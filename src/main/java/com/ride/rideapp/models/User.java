package com.ride.rideapp.models;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    int id;

    String username, mobile, password;
    boolean account_status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAccount_status() {
        return account_status;
    }

    public void setAccount_status(boolean account_status) {
        this.account_status = account_status;
    }
}
