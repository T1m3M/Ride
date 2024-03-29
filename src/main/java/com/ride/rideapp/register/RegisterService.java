package com.ride.rideapp.register;

import com.ride.rideapp.models.Admin;
import com.ride.rideapp.models.Customer;
import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegisterService {

    @Autowired
    RegisterRepo registerRepo;

    public Admin registerAdmin(String username, String mobile, String password) {
        return registerRepo.registerAdmin(username, mobile, password);
    }

    public Customer registerCustomer(String username, String mobile, String password, Date birthdate) {
        return registerRepo.registerCustomer(username, mobile, password, birthdate);
    }

    public Driver registerDriver(String username, String mobile, String password, String national_id, String driver_license, int seats_number) {
        return registerRepo.registerDriver(username, mobile, password, national_id, driver_license, seats_number);
    }
}
