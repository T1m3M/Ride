package com.ride.rideapp.putOffer;

import com.ride.rideapp.helperClasses.DiscountCalculator;
import com.ride.rideapp.mappers.OfferRowMapper;
import com.ride.rideapp.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;

@Repository
public class PutOfferRepo {

    @Autowired
    private JdbcTemplate conn;

    private DiscountCalculator discountCalculator;

    public Offer putOffer(Integer driver_id, Integer ride_id, Float price) {

        String sql = "SELECT * FROM offers WHERE driver_id=" + driver_id + " AND ride_id=" + ride_id;
        List<Offer> result = conn.query(sql, new OfferRowMapper());

        if (result.isEmpty()) {
            // getting last offer id
            sql = "SELECT * FROM offers ORDER BY id DESC LIMIT 1";
            result = conn.query(sql, new OfferRowMapper());

            int lastId = 0;
            if (!result.isEmpty()) lastId = result.get(0).getId();

            // saving offer object
            Offer offer = new Offer();
            offer.setId(lastId + 1);
            offer.setRide_id(ride_id);
            offer.setDriver_id(driver_id);
            offer.setPrice(price);
            offer.setOffer_time(new Timestamp(System.currentTimeMillis()));
            offer.setOffer_status(true);

            // calculating all discounts for this price
            offer.setAfter_discount(discountCalculator.calculateDiscount(offer));

            sql = "INSERT INTO offers(id, ride_id, driver_id, price, offer_time, offer_status) VALUES(?, ?, ?, ?, ?, ?)";
            conn.update(sql, offer.getId(), offer.getRide_id(), offer.getDriver_id(), offer.getPrice(), offer.getOffer_time(), offer.getOffer_status());

            return offer;

        }

        return null;
    }
}
