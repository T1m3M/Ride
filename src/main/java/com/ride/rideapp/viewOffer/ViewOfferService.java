package com.ride.rideapp.viewOffer;

import com.ride.rideapp.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewOfferService {

    @Autowired
    private ViewOfferRepo viewOfferRepo;

    public Offer viewOffer(int offer_id) {
        return viewOfferRepo.viewOffer(offer_id);
    }
}
