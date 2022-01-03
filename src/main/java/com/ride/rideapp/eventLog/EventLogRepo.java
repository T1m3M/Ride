package com.ride.rideapp.eventLog;

import com.ride.rideapp.mappers.OfferEventRowMapper;
import com.ride.rideapp.mappers.RideRowMapper;
import com.ride.rideapp.models.AcceptOfferEvent;
import com.ride.rideapp.models.OfferEvent;
import com.ride.rideapp.models.Ride;
import com.ride.rideapp.models.TrackRideEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class EventLogRepo {

    @Autowired
    JdbcTemplate conn;

    public OfferEvent showOffer(int ride_id) {
        String sql = "SELECT offers.offer_time, drivers.username, offers.price " +
                     "FROM offers, drivers " +
                     "WHERE offers.ride_id = " + ride_id + " AND drivers.id = offers.driver_id";

        List<OfferEvent> result = conn.query(sql, new OfferEventRowMapper());

        if (!result.isEmpty()) {

            // updating offer event object
            OfferEvent offer = result.get(0);
            offer.setEvent_name("OFFER_EVENT");

            return offer;
        }

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
