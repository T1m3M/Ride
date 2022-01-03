package com.ride.rideapp.viewOffer;

import com.ride.rideapp.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class ViewOfferController {

    @Autowired
    private ViewOfferService viewOfferService;

    @GetMapping("/view_offer")
    public Offer verifyDriver(@RequestParam(value="offer_id") Integer offer_id){
        return viewOfferService.viewOffer(offer_id);
    }
}