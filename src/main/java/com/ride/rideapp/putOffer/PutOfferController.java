package com.ride.rideapp.putOffer;

import com.ride.rideapp.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/driver")
public class PutOfferController {

    @Autowired
    PutOfferService putOfferService;


    @PostMapping("/put_offer")
    public Offer putOffer(
            @RequestParam(value="driver_id") Integer driver_id,
            @RequestParam(value="ride_id") Integer ride_id,
            @RequestParam(value="price") Float price) {
        return putOfferService.putOffer(driver_id, ride_id, price);
    }
}
