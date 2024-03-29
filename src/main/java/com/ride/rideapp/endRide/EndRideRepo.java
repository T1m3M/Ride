package com.ride.rideapp.endRide;

import com.ride.rideapp.mappers.RideRowMapper;
import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class EndRideRepo {

    @Autowired
    JdbcTemplate conn;

    public Ride endRide(int ride_id) {
        String sql = "SELECT * FROM rides WHERE id=" + ride_id + " AND ride_status=false AND end_time IS NULL";
        List<Ride> result = conn.query(sql, new RideRowMapper());

        if (!result.isEmpty()) {

            // updating ride object
            Ride ride = result.get(0);
            ride.setEnd_time(new Timestamp(System.currentTimeMillis()));

            // change ride start time
            sql = "UPDATE rides SET end_time=? WHERE id=" + ride_id;
            conn.update(sql, ride.getEnd_time());

            // change driver available status
            sql = "UPDATE drivers SET available_status=? WHERE id=" + ride_id;
            conn.update(sql, true);

            return ride;
        }

        return null;
    }
}
