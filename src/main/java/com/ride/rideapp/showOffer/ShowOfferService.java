package com.ride.rideapp.showOffer;

import com.ride.rideapp.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowOfferService {

    @Autowired
    ShowOfferRepo showOfferRepo;

    public Event showOffer(int ride_id) {
        return showOfferRepo.showOffer(ride_id);
    }
}
