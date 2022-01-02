package com.ride.rideapp.endRide;

import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/driver")
public class EndRideController {

    @Autowired
    EndRideService endRideService;

    @PutMapping("/end_ride")
    public Ride endRide(@RequestParam("ride_id") Integer ride_id) {
        return endRideService.endRide(ride_id);
    }

}
