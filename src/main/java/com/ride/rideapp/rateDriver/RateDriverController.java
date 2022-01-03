package com.ride.rideapp.rateDriver;

import com.ride.rideapp.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class RateDriverController {

    @Autowired
    RateDriverService rateDriverService;

    @PostMapping("/rate_driver")
    public Rating rateDriver(@RequestParam("ride_id") Integer ride_id,
                             @RequestParam("rating") Integer rating) {
        return rateDriverService.rateDriver(ride_id, rating);
    }
}
