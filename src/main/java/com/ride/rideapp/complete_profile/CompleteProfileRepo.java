package com.ride.rideapp.complete_profile;

import com.ride.rideapp.mappers.CustomerRowMapper;
import com.ride.rideapp.mappers.DriverRowMapper;
import com.ride.rideapp.models.Customer;
import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompleteProfileRepo {
    @Autowired
    private JdbcTemplate conn;


    public Driver completeProfile(int id, String national_id, String driver_license) {
        String sql = "SELECT * FROM drivers WHERE id=" + id + " AND national_id IS NULL AND driver_license IS NULL";
        List<Driver> result = conn.query(sql, new DriverRowMapper());

        if (!result.isEmpty()) {

            // updating admin user object
            Driver user = result.get(0);
            user.setNational_id(national_id);
            user.setDriver_license(driver_license);

            sql = "UPDATE drivers SET national_id=?, driver_license=? WHERE id=" + id;
            conn.update(sql, user.getNational_id(), user.getDriver_license());

            return user;

        }

        return null;
    }
}
