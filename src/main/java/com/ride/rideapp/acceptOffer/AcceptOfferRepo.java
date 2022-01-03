package com.ride.rideapp.acceptOffer;

import com.ride.rideapp.mappers.CustomerRowMapper;
import com.ride.rideapp.mappers.OfferRowMapper;
import com.ride.rideapp.models.Customer;
import com.ride.rideapp.models.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class AcceptOfferRepo {

    @Autowired
    private JdbcTemplate conn;

    public Offer acceptOffer(int offer_id) {
        String sql = "SELECT * FROM offers WHERE id=" + offer_id + " AND offer_status=true";
        List<Offer> result = conn.query(sql, new OfferRowMapper());

        if (!result.isEmpty()) {

            // updating offer object
            Offer offer = result.get(0);

            // getting customer balance
            float fare = offer.getAfter_discount();
            int ride_id = offer.getRide_id();

            sql = "SELECT customers.* FROM customers, rides WHERE rides.id=" + ride_id + " AND rides.customer_id = customers.id";
            List<Customer> customers = conn.query(sql, new CustomerRowMapper());

            float customer_balance = customers.get(0).getBalance();

            // only when the customer can pay
            if (customer_balance >= fare) {
                offer.setOffer_status(false);
                offer.setAccept_time(new Timestamp(System.currentTimeMillis()));

                sql = "UPDATE offers SET offer_status=?, accept_time=? WHERE id=" + offer_id;
                conn.update(sql, offer.getOffer_status(), offer.getAccept_time());

                // change ride status
                sql = "UPDATE rides SET offer_id=?, ride_status=? WHERE id=" + offer.getRide_id();
                conn.update(sql, offer.getId(), false);

                return offer;
            }
        }

        return null;
    }
}
