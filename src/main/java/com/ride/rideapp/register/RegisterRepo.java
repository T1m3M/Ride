package com.ride.rideapp.register;

import com.ride.rideapp.mappers.AdminRowMapper;
import com.ride.rideapp.mappers.CustomerRowMapper;
import com.ride.rideapp.mappers.DriverRowMapper;
import com.ride.rideapp.models.Admin;
import com.ride.rideapp.models.Customer;
import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.util.Date.parse;

@Repository
public class RegisterRepo {

    @Autowired
    private JdbcTemplate conn;


    public Admin registerAdmin(String username, String mobile, String password) {

        String sql = "SELECT * FROM admins WHERE mobile=" + mobile;
        List<Admin> result = conn.query(sql, new AdminRowMapper());

        if (result.isEmpty()) {
            // getting last admin id
            sql = "SELECT * FROM admins ORDER BY id DESC LIMIT 1";
            result = conn.query(sql, new AdminRowMapper());
            int lastId = result.get(0).getId();

            // saving admin user object
            Admin user = new Admin();
            user.setId(lastId + 1);
            user.setUsername(username);
            user.setMobile(mobile);
            user.setPassword(password);

            sql = "INSERT INTO admins(id, username, mobile, password) VALUES(?, ?, ?, ?)";
            conn.update(sql, user.getId(), user.getUsername(), user.getMobile(), user.getPassword());

            return user;

        }

        return null;
    }

    public Customer registerCustomer(String username, String mobile, String password, Date birthdate) {

        String sql = "SELECT * FROM customers WHERE mobile=" + mobile;
        List<Customer> result = conn.query(sql, new CustomerRowMapper());

        if (result.isEmpty()) {
            // getting last admin id
            sql = "SELECT * FROM customers ORDER BY id DESC LIMIT 1";
            result = conn.query(sql, new CustomerRowMapper());
            int lastId = result.get(0).getId();

            // saving admin user object
            Customer user = new Customer();
            user.setId(lastId + 1);
            user.setUsername(username);
            user.setMobile(mobile);
            user.setPassword(password);
            user.setAccount_status(true);
            user.setBirthdate(birthdate);
            user.setBalance(0);

            sql = "INSERT INTO customers(id, username, mobile, password, account_status, birthdate, balance) VALUES(?, ?, ?, ?, ?, ?, ?)";
            conn.update(sql, user.getId(), user.getUsername(), user.getMobile(), user.getPassword(), user.getAccount_status(), user.getBirthdate(), user.getBalance());

            return user;

        }

        return null;

    }

    public Driver registerDriver(String username, String mobile, String password, String national_id, String driver_license, int seats_num) {
        String sql = "SELECT * FROM drivers WHERE mobile=" + mobile;
        List<Driver> result = conn.query(sql, new DriverRowMapper());

        if (result.isEmpty()) {
            // getting last admin id
            sql = "SELECT * FROM drivers ORDER BY id DESC LIMIT 1";
            result = conn.query(sql, new DriverRowMapper());
            int lastId = result.get(0).getId();

            // saving admin user object
            Driver user = new Driver();
            user.setId(lastId + 1);
            user.setUsername(username);
            user.setMobile(mobile);
            user.setPassword(password);
            user.setAccount_status(true);
            user.setNational_id(national_id);
            user.setDriver_license(driver_license);
            user.setAverage_rating(0.0F);
            user.setVerification_status(false);
            user.setAvailable_status(true);
            user.setSeats_number(seats_num);
            user.setBalance(0);

            sql = "INSERT INTO drivers(id, username, mobile, password, account_status, national_id, driver_license, average_rating, verification_status, available_status, seats_number, balance) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            conn.update(
                    sql,
                    user.getId(),
                    user.getUsername(),
                    user.getMobile(),
                    user.getPassword(),
                    user.getAccount_status(),
                    user.getNational_id(),
                    user.getDriver_license(),
                    user.getAverage_rating(),
                    user.getVerification_status(),
                    user.getAvailable_status(),
                    user.getSeats_number(),
                    user.getBalance()
            );

            return user;

        }

        return null;
    }
}
