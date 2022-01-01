package com.ride.rideapp.mappers;

import com.ride.rideapp.models.Driver;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverRowMapper implements RowMapper<Driver> {

    public Driver mapRow(ResultSet rs, int rowNum) throws SQLException {
        Driver user = new Driver();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setMobile(rs.getString("mobile"));
        user.setPassword(rs.getString("password"));
        user.setAccount_status(rs.getBoolean("account_status"));
        user.setNational_id(rs.getString("national_id"));
        user.setDriver_license(rs.getString("driver_license"));
        user.setAverage_rating(rs.getFloat("average_rating"));
        user.setVerification_status(rs.getBoolean("verification_status"));

        return user;
    }
}
