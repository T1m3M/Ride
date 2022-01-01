package com.ride.rideapp.verifyDriverRegistration;

import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerifyDriverRegistrationService {

    @Autowired
    private VerifyDriverRegistrationRepo verifyDriverRegistrationRepo;

    public Driver verifyDriver(int id) {
        return verifyDriverRegistrationRepo.verify(id);
    }
}
