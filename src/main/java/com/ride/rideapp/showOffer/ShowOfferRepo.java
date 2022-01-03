package com.ride.rideapp.showOffer;

import com.ride.rideapp.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShowOfferRepo {

    @Autowired
    JdbcTemplate conn;

    public Event showOffer(int ride_id) {
        return null;
    }
}
