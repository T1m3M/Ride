package com.ride.rideapp.login;
import com.ride.rideapp.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoginRepo {

    @Autowired
    private JdbcTemplate conn;

    RowMapper<Admin> adminRowMapper = (rs, rowNum) -> {
        Admin admin = new Admin();
        admin.setId(rs.getInt("id"));
        admin.setUsername(rs.getString("username"));
        admin.setMobile(rs.getString("mobile"));
        admin.setPassword(rs.getString("password"));
        admin.setAccount_status(rs.getBoolean("account_status"));

        return admin;
    };

    public Admin loginAdmin(String mobile, String password) {
        String sql = "SELECT * FROM admins WHERE mobile=" + mobile + " AND password=" + password;
        List<Admin> result = conn.query(sql, adminRowMapper);

        if (!result.isEmpty())
            return result.get(0);
        return null;
    }
}
