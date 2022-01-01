package com.ride.rideapp.login;
import com.ride.rideapp.models.Admin;
import com.ride.rideapp.models.Customer;
import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginRepo {

    @Autowired
    private JdbcTemplate conn;


    public Admin loginAdmin(String mobile, String password) {
        String sql = "SELECT * FROM admins WHERE mobile=" + mobile + " AND password=" + password;
        List<Admin> result = conn.query(sql, new AdminRowMapper());

        if (!result.isEmpty())
            return result.get(0);
        return null;
    }


    public Customer loginCustomer(String mobile, String password) {
        String sql = "SELECT * FROM customers WHERE mobile=" + mobile + " AND password=" + password;
        List<Customer> result = conn.query(sql, new CustomerRowMapper());

        if (!result.isEmpty())
            return result.get(0);
        return null;
    }

    public Driver loginDriver(String mobile, String password) {
        String sql = "SELECT * FROM drivers WHERE mobile=" + mobile + " AND password=" + password;
        List<Driver> result = conn.query(sql, new DriverRowMapper());

        if (!result.isEmpty())
            return result.get(0);
        return null;
    }
}
