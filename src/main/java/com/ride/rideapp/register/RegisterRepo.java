package com.ride.rideapp.register;

import com.ride.rideapp.mappers.AdminRowMapper;
import com.ride.rideapp.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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

//        String sql = "INSERT INTO admins(id, username, mobile, password) VALUES(?, ?, ?, ?)";
//
//        return conn.update(sql, username, mobileNumber, password);
    }
}
