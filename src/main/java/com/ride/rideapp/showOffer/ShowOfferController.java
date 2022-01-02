package com.ride.rideapp.showOffer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/event")
public class ShowOfferController {

    ShowOfferService showOfferService;

    @GetMapping("/show_offer")
    public Event showOffer(@RequestMapping("ride_id") Integer ride_id) {
        return null;
    }

}
