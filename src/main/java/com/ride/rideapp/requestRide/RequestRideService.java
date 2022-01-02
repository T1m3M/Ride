package com.ride.rideapp.requestRide;

import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestRideService {

    @Autowired
    RequestRideRepo requestRideRepo;

    public Ride requestRide(String source, String destination, Integer number_of_passengers) {
        return requestRideRepo.requestRide(source, destination, number_of_passengers);
    }
}
