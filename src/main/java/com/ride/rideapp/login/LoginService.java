package com.ride.rideapp.login;

import com.ride.rideapp.models.Admin;
import com.ride.rideapp.models.Customer;
import com.ride.rideapp.models.Driver;
import com.ride.rideapp.models.User;
import com.ride.rideapp.register.RegisterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepo loginRepo;


    public Admin loginAdmin(String mobile, String password) {
        return loginRepo.loginAdmin(mobile, password);
    }

    public Customer loginCustomer(String mobile, String password) {
        return loginRepo.loginCustomer(mobile, password);
    }

    public Driver loginDriver(String mobile, String password) {
        return loginRepo.loginDriver(mobile, password);
    }
}
