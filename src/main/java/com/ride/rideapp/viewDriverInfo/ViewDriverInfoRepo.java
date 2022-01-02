package com.ride.rideapp.viewDriverInfo;

import com.ride.rideapp.mappers.DriverInfoRowMapper;
import com.ride.rideapp.mappers.DriverRowMapper;
import com.ride.rideapp.models.Driver;
import com.ride.rideapp.models.DriverInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ViewDriverInfoRepo {

    @Autowired
    private JdbcTemplate conn;

    public DriverInfo viewDriverInfo(Integer driver_id) {
        String sql = "SELECT * FROM drivers WHERE id=" + driver_id;
        List<DriverInfo> result = conn.query(sql, new DriverInfoRowMapper());

        if (!result.isEmpty())
            return result.get(0);

        return null;
    }
}
