package com.ride.rideapp.addDiscount;

import com.ride.rideapp.mappers.DiscountRowMapper;
import com.ride.rideapp.mappers.FavoriteAreaRowMapper;
import com.ride.rideapp.models.Discount;
import com.ride.rideapp.models.FavoriteArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddDiscountRepo {

    @Autowired
    JdbcTemplate conn;

    public Discount addDiscount(String area_name) {
        String sql = "SELECT * FROM discounts WHERE area_name='" + area_name + "'";
        List<Discount> result = conn.query(sql, new DiscountRowMapper());

        if (result.isEmpty()) {
            // getting last discount id
            sql = "SELECT * FROM discounts ORDER BY id DESC LIMIT 1";
            result = conn.query(sql, new DiscountRowMapper());

            int lastId = 0;
            if (!result.isEmpty()) lastId = result.get(0).getId();

            // saving discount object
            Discount discount = new Discount();
            discount.setId(lastId + 1);
            discount.setArea_name(area_name);
            discount.setRate(10.0F);

            sql = "INSERT INTO discounts(id, area_name, rate) VALUES(?, ?, ?)";
            conn.update(
                    sql,
                    discount.getId(),
                    discount.getArea_name(),
                    discount.getRate()
            );

            return discount;

        }

        return null;
    }
}
