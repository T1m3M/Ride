package com.ride.rideapp.listPendingRegistrations;

import com.ride.rideapp.mappers.DriverRowMapper;
import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ListPendingRegistrationsRepo {
    @Autowired
    private JdbcTemplate conn;

    public List<Driver> listAll() {
        String sql = "SELECT * FROM drivers WHERE verification_status=false";
        List<Driver> result = conn.query(sql, new DriverRowMapper());

        if (!result.isEmpty())
            return result;
        return null;
    }
}
