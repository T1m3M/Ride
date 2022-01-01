package com.ride.rideapp.register;

import com.ride.rideapp.models.User;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {
    User register(String username, String mobile, String password);
}
