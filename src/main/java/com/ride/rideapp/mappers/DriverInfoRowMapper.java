package com.ride.rideapp.mappers;

import com.ride.rideapp.models.DriverInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverInfoRowMapper implements RowMapper<DriverInfo> {

    public DriverInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
        DriverInfo driverInfo = new DriverInfo();
        driverInfo.setUsername(rs.getString("username"));
        driverInfo.setMobile(rs.getString("mobile"));
        driverInfo.setAverage_rating(rs.getFloat("average_rating"));
        driverInfo.setVerification_status(rs.getBoolean("verification_status"));
        driverInfo.setSeats_number(rs.getInt("seats_number"));

        return driverInfo;
    }
}
