package com.ride.rideapp.getFare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class GetFareController {

    @Autowired
    GetFareService getFareService;

    @GetMapping("/get_fare")
    public float getFare(@RequestParam("ride_id") Integer ride_id) {
        return getFareService.getFare(ride_id);
    }

}
