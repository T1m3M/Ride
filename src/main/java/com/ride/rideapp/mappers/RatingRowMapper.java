package com.ride.rideapp.mappers;

import com.ride.rideapp.models.Rating;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingRowMapper implements RowMapper<Rating> {

    public Rating mapRow(ResultSet rs, int rowNum) throws SQLException {
        Rating rating = new Rating();
        rating.setId(rs.getInt("id"));
        rating.setRide_id(rs.getInt("ride_id"));
        rating.setDriver_id(rs.getInt("driver_id"));
        rating.setRating(rs.getInt("rating"));

        return rating;
    }


}
