package com.ride.rideapp.suspendAccounts;

import com.ride.rideapp.mappers.CustomerRowMapper;
import com.ride.rideapp.mappers.DriverRowMapper;
import com.ride.rideapp.models.Customer;
import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SuspendAccountRepo {

    @Autowired
    private JdbcTemplate conn;


    public Customer suspendCustomer(int id) {

        String sql = "SELECT * FROM customers WHERE id=" + id + " AND account_status=true";
        List<Customer> result = conn.query(sql, new CustomerRowMapper());

        if (!result.isEmpty()) {

            // updating admin user object
            Customer user = result.get(0);
            user.setAccount_status(false);

            sql = "UPDATE customers SET account_status=? WHERE id=" + id;
            conn.update(sql, user.getAccount_status());

            return user;
        }

        return null;
    }

    public Driver suspendDriver(int id) {

        String sql = "SELECT * FROM drivers WHERE id=" + id + " AND account_status=true";
        List<Driver> result = conn.query(sql, new DriverRowMapper());

        if (!result.isEmpty()) {

            // updating admin user object
            Driver user = result.get(0);
            user.setAccount_status(false);

            sql = "UPDATE drivers SET account_status=? WHERE id=" + id;
            conn.update(sql, user.getAccount_status());

            return user;
        }

        return null;
    }
}
