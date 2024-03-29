package com.ride.rideapp.mappers;

import com.ride.rideapp.models.Ride;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RideRowMapper implements RowMapper<Ride> {

    public Ride mapRow(ResultSet rs, int rowNum) throws SQLException {
        Ride ride = new Ride();
        ride.setId(rs.getInt("id"));
        ride.setCustomer_id(rs.getInt("customer_id"));
        ride.setSource(rs.getString("source"));
        ride.setDestination(rs.getString("destination"));
        ride.setNumber_of_passengers(rs.getInt("number_of_passengers"));
        ride.setStart_time(rs.getTimestamp("start_time"));
        ride.setEnd_time(rs.getTimestamp("end_time"));
        ride.setOffer_id(rs.getInt("offer_id"));
        ride.setRide_status(rs.getBoolean("ride_status"));
        ride.setPaid_status(rs.getBoolean("paid_status"));

        return ride;
    }


}
