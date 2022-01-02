package com.ride.rideapp.requestRide;

import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class RequestRideController {

    @Autowired
    private RequestRideService requestRideService;

    @PostMapping("/request_ride")
    public Ride requestRide(
            @RequestParam(value="source") String source,
            @RequestParam(value="destination") String destination,
            @RequestParam(value="number_of_passengers") Integer number_of_passengers) {
        return requestRideService.requestRide(source, destination, number_of_passengers);
    }


}
