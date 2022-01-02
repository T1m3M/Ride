package com.ride.rideapp.getFare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetFareService {

    @Autowired
    GetFareRepo getFareRepo;

    public float getFare(int ride_id) {
        return getFareRepo.getFare(ride_id);
    }
}
