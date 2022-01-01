package com.ride.rideapp.login;

import com.ride.rideapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepo loginRepo;

    public User login(String mobile, String password) {
        return loginRepo.loginUser(mobile, password);
    }
}
