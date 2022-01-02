package com.ride.rideapp.showOffer;

import com.ride.rideapp.models.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/event")
public class ShowOfferController {

    ShowOfferService showOfferService;

    @GetMapping("/show_offer")
    public Event showOffer(@RequestParam("ride_id") Integer ride_id) {
        return null;
    }

}
