package com.ride.rideapp.mappers;

import com.ride.rideapp.models.Offer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimeZone;

public class OfferRowMapper implements RowMapper<Offer> {

    public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Offer offer = new Offer();
        offer.setId(rs.getInt("id"));
        offer.setRide_id(rs.getInt("ride_id"));
        offer.setDriver_id(rs.getInt("driver_id"));
        offer.setPrice(rs.getFloat("price"));
        offer.setOffer_time(rs.getTimestamp("offer_time"));
        offer.setAccept_time(rs.getTimestamp("accept_time"));
        offer.setOffer_status(rs.getBoolean("offer_status"));

        return offer;
    }


}
