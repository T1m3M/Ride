package com.ride.rideapp.mappers;

import com.ride.rideapp.models.FavoriteArea;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteAreaRowMapper implements RowMapper<FavoriteArea> {

    public FavoriteArea mapRow(ResultSet rs, int rowNum) throws SQLException {
        FavoriteArea area = new FavoriteArea();
        area.setId(rs.getInt("id"));
        area.setArea_name(rs.getString("area_name"));
        area.setDriver_id(rs.getInt("driver_id"));

        return area;
    }


}
