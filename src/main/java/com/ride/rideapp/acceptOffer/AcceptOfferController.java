package com.ride.rideapp.acceptOffer;

import com.ride.rideapp.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class AcceptOfferController {

    @Autowired
    AcceptOfferService acceptOfferService;

    @PutMapping("/accept_offer")
    public Offer acceptOffer(@RequestParam("offer_id") Integer offer_id) {
        return acceptOfferService.acceptOffer(offer_id);
    }
}
