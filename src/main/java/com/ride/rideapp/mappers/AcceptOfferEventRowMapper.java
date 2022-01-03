package com.ride.rideapp.mappers;

import com.ride.rideapp.models.AcceptOfferEvent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AcceptOfferEventRowMapper implements RowMapper<AcceptOfferEvent> {

    public AcceptOfferEvent mapRow(ResultSet rs, int rowNum) throws SQLException {
        AcceptOfferEvent accept_offer = new AcceptOfferEvent();
        accept_offer.setEvent_time(rs.getTimestamp("accept_time"));
        accept_offer.setUser_name(rs.getString("username"));

        return accept_offer;
    }
}
