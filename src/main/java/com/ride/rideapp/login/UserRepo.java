package com.ride.rideapp.login;
import com.ride.rideapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRepo {

    private final JdbcTemplate conn;

    public UserRepo(JdbcTemplate jdbcTemplate) {
        this.conn = jdbcTemplate;
    }

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
        String sql = "SELECT * FROM admins WHERE mobile = " + mobile + " AND password = " + password;
        return (User) conn.query(sql, rowMapper);
    }
}
