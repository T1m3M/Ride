package com.ride.rideapp.login;
import com.ride.rideapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepo {

    @Autowired
    private JdbcTemplate conn;

    RowMapper<User> rowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setMobile(rs.getString("mobile"));
        user.setPassword(rs.getString("password"));
        user.setAccount_status(rs.getBoolean("account_status"));

        return user;
    };

    public User loginUser(String mobile, String password) {
        String sql = "SELECT * FROM admins WHERE mobile=" + mobile + " AND password=" + password;
        List<User> result = conn.query(sql, rowMapper);

        if (!result.isEmpty())
            return result.get(0);
        return null;
    }
}
