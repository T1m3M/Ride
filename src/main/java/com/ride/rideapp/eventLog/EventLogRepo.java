package com.ride.rideapp.eventLog;

import com.ride.rideapp.mappers.AcceptOfferEventRowMapper;
import com.ride.rideapp.mappers.OfferEventRowMapper;
import com.ride.rideapp.mappers.TrackRideEventRowMapper;
import com.ride.rideapp.models.AcceptOfferEvent;
import com.ride.rideapp.models.OfferEvent;
import com.ride.rideapp.models.TrackRideEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

        String sql = "SELECT offers.accept_time, customers.username " +
                     "FROM offers, customers, rides " +
                     "WHERE offers.ride_id = " + ride_id + " AND offers.ride_id = rides.id AND rides.customer_id = customers.id";

        List<AcceptOfferEvent> result = conn.query(sql, new AcceptOfferEventRowMapper());

        if (!result.isEmpty()) {

            // updating offer event object
            AcceptOfferEvent accept_offer = result.get(0);
            accept_offer.setEvent_name("ACCEPT_OFFER_EVENT");

            return accept_offer;
        }

        return null;
    }

    public TrackRideEvent rideStart(int ride_id) {

        String sql = "SELECT rides.start_time as event_time, drivers.username, customers.username " +
                     "FROM rides, drivers, customers, offers " +
                     "WHERE rides.id = " + ride_id + " AND rides.customer_id = customers.id AND rides.offer_id = offers.id AND offers.driver_id = drivers.id";

        List<TrackRideEvent> result = conn.query(sql, new TrackRideEventRowMapper());

        if (!result.isEmpty()) {

            // updating track ride event object
            TrackRideEvent track_ride = result.get(0);
            track_ride.setEvent_name("RIDE_START_EVENT");

            return track_ride;
        }

        return null;
    }

    public TrackRideEvent rideEnd(int ride_id) {

        String sql = "SELECT rides.end_time as event_time, drivers.username, customers.username " +
                "FROM rides, drivers, customers, offers " +
                "WHERE rides.id = " + ride_id + " AND rides.customer_id = customers.id AND rides.offer_id = offers.id AND offers.driver_id = drivers.id";

        List<TrackRideEvent> result = conn.query(sql, new TrackRideEventRowMapper());

        if (!result.isEmpty()) {

            // updating track ride event object
            TrackRideEvent track_ride = result.get(0);
            track_ride.setEvent_name("RIDE_END_EVENT");

            return track_ride;
        }

        return null;
    }
}
