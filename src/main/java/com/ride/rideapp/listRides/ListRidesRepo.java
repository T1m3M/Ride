package com.ride.rideapp.listRides;

import com.ride.rideapp.mappers.DriverRowMapper;
import com.ride.rideapp.mappers.RideRowMapper;
import com.ride.rideapp.models.Driver;
import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListRidesRepo {

    @Autowired
    private JdbcTemplate conn;

    public List<Ride> listRides(int driver_id) {
        String sql = "SELECT * FROM rides WHERE source IN (SELECT area_name FROM favorite_areas WHERE driver_id=" + driver_id + ") AND ride_status NOT LIKE false";
        List<Ride> result = conn.query(sql, new RideRowMapper());

        if (!result.isEmpty())
            return result;
        return null;
    }
}
