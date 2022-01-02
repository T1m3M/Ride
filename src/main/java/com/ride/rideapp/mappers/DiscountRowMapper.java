package com.ride.rideapp.mappers;

import com.ride.rideapp.models.Discount;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DiscountRowMapper implements RowMapper<Discount> {

    public Discount mapRow(ResultSet rs, int rowNum) throws SQLException {
        Discount discount = new Discount();
        discount.setId(rs.getInt("id"));
        discount.setArea_name(rs.getString("area_name"));
        discount.setRate(rs.getFloat("rate"));

        return discount;
    }


}
