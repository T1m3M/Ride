package com.ride.rideapp.models;

import com.ride.rideapp.login.LoginService;
import com.ride.rideapp.login.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

public abstract class User implements LoginService {
    @Id
    int id;

    String username, mobile, password;

    @Autowired
    LoginRepo loginRepo;

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

}
