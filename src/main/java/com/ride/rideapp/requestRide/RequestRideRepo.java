package com.ride.rideapp.requestRide;

import com.ride.rideapp.mappers.AdminRowMapper;
import com.ride.rideapp.mappers.RideRowMapper;
import com.ride.rideapp.models.Admin;
import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestRideRepo {

    @Autowired
    private JdbcTemplate conn;

    public Ride requestRide(int customer_id, String source, String destination, Integer number_of_passengers) {

        // getting last ride id
        String sql = "SELECT * FROM rides ORDER BY id DESC LIMIT 1";
        List<Ride> result = conn.query(sql, new RideRowMapper());

        int lastId = 0;
        if (!result.isEmpty()) lastId = result.get(0).getId();

        // saving ride object
        Ride ride = new Ride();
        ride.setId(lastId + 1);
        ride.setCustomer_id(customer_id);
        ride.setSource(source);
        ride.setDestination(destination);
        ride.setNumber_of_passengers(number_of_passengers);
        ride.setRide_status(true);
        ride.setRide_status(false);

        sql = "INSERT INTO rides(id, customer_id, source, destination, number_of_passengers, ride_status, paid_status) VALUES(?, ?, ?, ?, ?, ?, ?)";
        conn.update(sql, ride.getId(), ride.getCustomer_id(), ride.getSource(), ride.getDestination(), ride.getNumber_of_passengers(), ride.getRide_status(), ride.getPaid_status());

        return ride;
    }
}
