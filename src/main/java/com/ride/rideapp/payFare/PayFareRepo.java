package com.ride.rideapp.payFare;

import com.ride.rideapp.mappers.*;
import com.ride.rideapp.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PayFareRepo {

    @Autowired
    JdbcTemplate conn;

    public Ride payFare(int ride_id) {
        String sql = "SELECT offers.* " +
                     "FROM offers, rides " +
                     "WHERE rides.id = " + ride_id + " AND rides.offer_id = offers.id AND rides.paid_status=false AND rides.start_time IS NOT NULL AND rides.end_time IS NOT NULL";

        List<Offer> result = conn.query(sql, new OfferRowMapper());

        if (!result.isEmpty()) {

            Offer offer = result.get(0);

            sql = "SELECT * FROM rides WHERE id=" + ride_id;
            Ride ride = conn.query(sql, new RideRowMapper()).get(0);

            int customer_id = ride.getCustomer_id();
            int driver_id = offer.getDriver_id();

            float original_price = offer.getPrice();
            float after_discount = offer.getAfter_discount();

            sql = "SELECT * FROM customers WHERE id=" + customer_id;
            Customer customer = conn.query(sql, new CustomerRowMapper()).get(0);

            sql = "SELECT * FROM drivers WHERE id=" + driver_id;
            Driver driver = conn.query(sql, new DriverRowMapper()).get(0);

            // subtract after discount from customer's balance
            float customer_new_balance = customer.getBalance() - after_discount;

            sql = "UPDATE customers SET balance=? WHERE id=" + customer_id;
            conn.update(sql, customer_new_balance);


            // add original price to driver's balance
            float driver_new_balance = driver.getBalance() + original_price;

            sql = "UPDATE drivers SET balance=? WHERE id=" + driver_id;
            conn.update(sql, driver_new_balance);

            // set paid status flag in ride
            ride.setPaid_status(true);

            sql = "UPDATE rides SET paid_status=? WHERE id=" + ride_id;
            conn.update(sql, ride.getPaid_status());

            return ride;

        }

        return null;
    }
}
