package com.ride.rideapp.acceptOffer;

import com.ride.rideapp.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcceptOfferService {

    @Autowired
    AcceptOfferRepo acceptOfferRepo;

    public Offer acceptOffer(int offer_id) {
        return acceptOfferRepo.acceptOffer(offer_id);
    }
}
