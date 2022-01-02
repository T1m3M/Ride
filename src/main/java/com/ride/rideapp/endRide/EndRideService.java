package com.ride.rideapp.endRide;

import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EndRideService {

    @Autowired
    EndRideRepo endRideRepo;

    public Ride endRide(Integer ride_id) {
        return endRideRepo.endRide(ride_id);
    }
}
