package com.ride.rideapp.payFare;

import com.ride.rideapp.models.Discount;
import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class PayFareController {

    @Autowired
    PayFareService payFareService;

    @PutMapping("/pay_fare")
    public Ride payFare(@RequestParam("ride_id") Integer ride_id) {
        return payFareService.payFare(ride_id);
    }
}
