package com.ride.rideapp.eventLog;

import com.ride.rideapp.models.AcceptOfferEvent;
import com.ride.rideapp.models.OfferEvent;
import com.ride.rideapp.models.TrackRideEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EventLogRepo {

    @Autowired
    JdbcTemplate conn;

    public OfferEvent showOffer(int ride_id) {
        return null;
    }

    public AcceptOfferEvent offerAccept(int ride_id) {
        return null;
    }

    public TrackRideEvent rideStart(int ride_id) {
        return null;
    }

    public TrackRideEvent rideEnd(int ride_id) {
        return null;
    }
}
