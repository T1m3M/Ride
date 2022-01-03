package com.ride.rideapp.mappers;

import com.ride.rideapp.models.TrackRideEvent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackRideEventRowMapper implements RowMapper<TrackRideEvent> {

    public TrackRideEvent mapRow(ResultSet rs, int rowNum) throws SQLException {
        TrackRideEvent track_ride = new TrackRideEvent();
        track_ride.setEvent_time(rs.getTimestamp("event_time"));
        track_ride.setCaptain_name(rs.getString("drivers.username"));
        track_ride.setUser_name(rs.getString("customers.username"));

        return track_ride;
    }
}
