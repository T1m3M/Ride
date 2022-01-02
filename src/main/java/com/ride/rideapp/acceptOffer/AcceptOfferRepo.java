package com.ride.rideapp.acceptOffer;

import com.ride.rideapp.mappers.OfferRowMapper;
import com.ride.rideapp.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class AcceptOfferRepo {

    @Autowired
    private JdbcTemplate conn;

    public Offer acceptOffer(int offer_id) {
        String sql = "SELECT * FROM offers WHERE id=" + offer_id + " AND offer_status=true";
        List<Offer> result = conn.query(sql, new OfferRowMapper());

        if (!result.isEmpty()) {

            // updating offer object
            Offer offer = result.get(0);
            offer.setOffer_status(false);
            offer.setOffer_time(new Timestamp(System.currentTimeMillis()));

            sql = "UPDATE offers SET offer_status=?, accept_time=? WHERE id=" + offer_id;
            conn.update(sql, offer.getOffer_status(), offer.getOffer_time());

            // change ride status
            sql = "UPDATE rides SET offer_id=?, ride_status=? WHERE id=" + offer.getRide_id();
            conn.update(sql, offer.getId(), false);

            return offer;
        }

        return null;
    }
}
