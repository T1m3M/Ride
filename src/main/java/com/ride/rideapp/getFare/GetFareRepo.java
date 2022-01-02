package com.ride.rideapp.getFare;

import com.ride.rideapp.mappers.DiscountRowMapper;
import com.ride.rideapp.mappers.OfferRowMapper;
import com.ride.rideapp.mappers.RideRowMapper;
import com.ride.rideapp.models.Discount;
import com.ride.rideapp.models.Offer;
import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class GetFareRepo {

    @Autowired
    JdbcTemplate conn;

    public float getFare(int ride_id) {

        String sql = "SELECT * FROM rides WHERE id=" + ride_id;
        List<Ride> result = conn.query(sql, new RideRowMapper());

        if (!result.isEmpty()) {

            // getting offer id
            Ride ride = result.get(0);
            int offer_id = ride.getOffer_id();

            sql = "SELECT * FROM offers WHERE id=" + offer_id;
            List<Offer> offer_result = conn.query(sql, new OfferRowMapper());

            if (!offer_result.isEmpty()) {

                // getting ride price offered by driver
                float price = offer_result.get(0).getPrice();

                // subtracting admin discount on area
                String destination_name = ride.getDestination();
                sql = "SELECT * FROM discounts WHERE area_name='" + destination_name + "'";
                List<Discount> discount_result = conn.query(sql, new DiscountRowMapper());

                if (!discount_result.isEmpty()) {
                    Discount discount = discount_result.get(0);
                    float rate = discount.getRate();

                    // if ride has at least 2 passengers

                    // if first ride

                    // if today is public holiday

                    // if today is customer's birthday

                    return price - (price / rate);
                }

                return price;

            }
        }

        return -1;
    }
}
