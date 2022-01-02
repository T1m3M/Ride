package com.ride.rideapp.startRide;

import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartRideService {

    @Autowired
    StartRideRepo startRideRepo;

    public Ride startRide(Integer ride_id) {
        return startRideRepo.startRide(ride_id);
    }
}
