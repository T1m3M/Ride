package com.ride.rideapp.startRide;

import com.ride.rideapp.mappers.RideRowMapper;
import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class StartRideRepo {

    @Autowired
    JdbcTemplate conn;

    public Ride startRide(int ride_id) {
        String sql = "SELECT * FROM rides WHERE id=" + ride_id + " AND ride_status=false";
        List<Ride> result = conn.query(sql, new RideRowMapper());

        if (!result.isEmpty()) {

            // updating ride object
            Ride ride = result.get(0);
            ride.setStart_time(new Timestamp(System.currentTimeMillis()));

            // change ride start time
            sql = "UPDATE rides SET start_time=? WHERE id=" + ride_id;
            conn.update(sql, ride.getStart_time());

            return ride;
        }

        return null;
    }
}
