package com.ride.rideapp.mappers;

import com.ride.rideapp.models.Admin;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRowMapper implements RowMapper<Admin> {

    public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Admin user = new Admin();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setMobile(rs.getString("mobile"));
        user.setPassword(rs.getString("password"));

        return user;
    }
}
