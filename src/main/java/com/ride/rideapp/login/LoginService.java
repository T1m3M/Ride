package com.ride.rideapp.login;

import com.ride.rideapp.models.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    User login(String mobile, String password);
}
