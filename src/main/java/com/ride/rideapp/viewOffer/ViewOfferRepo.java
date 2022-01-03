package com.ride.rideapp.viewOffer;

import com.ride.rideapp.mappers.OfferRowMapper;
import com.ride.rideapp.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ViewOfferRepo {
    @Autowired
    private JdbcTemplate conn;

    public Offer viewOffer(int offer_id) {

        String sql = "SELECT * FROM offers WHERE id=" + offer_id;
        List<Offer> result = conn.query(sql, new OfferRowMapper());

        if (!result.isEmpty())
            return result.get(0);

        return null;
    }
}
