package com.ride.rideapp.rateDriver;

import com.ride.rideapp.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RateDriverService {

    @Autowired
    RateDriverRepo rateDriverRepo;

    public Rating rateDriver(int ride_id, int rating) {
        return rateDriverRepo.rateDriver(ride_id, rating);
    }
}
