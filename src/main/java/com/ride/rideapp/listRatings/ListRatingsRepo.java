package com.ride.rideapp.listRatings;

import com.ride.rideapp.mappers.RatingRowMapper;
import com.ride.rideapp.mappers.RideRowMapper;
import com.ride.rideapp.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListRatingsRepo {

    @Autowired
    private JdbcTemplate conn;

    public List<Rating> listRatings(int driver_id) {
        String sql = "SELECT * FROM ratings WHERE driver_id=" + driver_id;
        List<Rating> result = conn.query(sql, new RatingRowMapper());

        if (!result.isEmpty())
            return result;
        return null;
    }
}
