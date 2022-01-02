package com.ride.rideapp.putOffer;

import com.ride.rideapp.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PutOfferService {

    @Autowired
    PutOfferRepo putOfferRepo;
    public Offer putOffer(Integer driver_id, Integer ride_id, Float price) {
        return putOfferRepo.putOffer(driver_id, ride_id, price);
    }
}
