package com.ride.rideapp.mappers;

import com.ride.rideapp.models.OfferEvent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OfferEventRowMapper implements RowMapper<OfferEvent> {

    public OfferEvent mapRow(ResultSet rs, int rowNum) throws SQLException {
        OfferEvent offer = new OfferEvent();
        offer.setEvent_time(rs.getTimestamp("offer_time"));
        offer.setCaptain_name(rs.getString("username"));
        offer.setPrice(rs.getFloat("price"));

        return offer;
    }
}
