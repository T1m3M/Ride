package com.ride.rideapp;

import com.ride.rideapp.login.LoginRepo;
import com.ride.rideapp.login.LoginService;
import com.ride.rideapp.models.Admin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RideAppApplication {

    private static LoginService login;

    public RideAppApplication(LoginService login) {
        RideAppApplication.login = login;
    }

    public static void main(String[] args) {
        SpringApplication.run(RideAppApplication.class, args);

        Admin test = login.loginAdmin("123", "123");

        System.out.println(test.getId());
        System.out.println(test.getUsername());
        System.out.println(test.getMobile());
        System.out.println(test.getPassword());
    }

}
