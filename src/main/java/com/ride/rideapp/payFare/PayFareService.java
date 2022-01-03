package com.ride.rideapp.payFare;

import com.ride.rideapp.models.Discount;
import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayFareService {

    @Autowired
    PayFareRepo payFareRepo;

    public Ride payFare(int ride_id) {
        return payFareRepo.payFare(ride_id);
    }
}
