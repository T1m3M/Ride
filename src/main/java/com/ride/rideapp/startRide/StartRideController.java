package com.ride.rideapp.startRide;

import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/driver")
public class StartRideController {

    @Autowired
    StartRideService startRideService;

    @PutMapping("/start_ride")
    public Ride startRide(@RequestParam("ride_id") Integer ride_id) {
        return startRideService.startRide(ride_id);
    }

}
