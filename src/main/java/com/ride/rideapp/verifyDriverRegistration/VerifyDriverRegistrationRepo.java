package com.ride.rideapp.verifyDriverRegistration;

import com.ride.rideapp.mappers.DriverRowMapper;
import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VerifyDriverRegistrationRepo {
    @Autowired
    private JdbcTemplate conn;

    public Driver verify(int id) {

        String sql = "SELECT * FROM drivers WHERE id=" + id + " AND verification_status=false";
        List<Driver> result = conn.query(sql, new DriverRowMapper());

        if (!result.isEmpty()) {

            // updating admin user object
            Driver user = result.get(0);
            user.setVerification_status(true);

            sql = "UPDATE drivers SET verification_status=? WHERE id=" + id;
            conn.update(sql, user.getVerification_status());

            return user;

        }

        return null;
    }
}
