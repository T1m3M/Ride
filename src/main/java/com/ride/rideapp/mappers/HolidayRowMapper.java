package com.ride.rideapp.mappers;

import com.ride.rideapp.models.Holiday;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HolidayRowMapper implements RowMapper<Holiday> {

    public Holiday mapRow(ResultSet rs, int rowNum) throws SQLException {
        Holiday holiday = new Holiday();
        holiday.setId(rs.getInt("id"));
        holiday.setHoliday_date(rs.getDate("holiday_date"));

        return holiday;
    }
}
