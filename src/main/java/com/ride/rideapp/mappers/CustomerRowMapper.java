package com.ride.rideapp.mappers;

import com.ride.rideapp.models.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {

    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer user = new Customer();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setMobile(rs.getString("mobile"));
        user.setPassword(rs.getString("password"));
        user.setAccount_status(rs.getBoolean("account_status"));

        return user;
    }
}
