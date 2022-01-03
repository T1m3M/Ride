package com.ride.rideapp.helperClasses;

import com.ride.rideapp.mappers.CustomerRowMapper;
import com.ride.rideapp.mappers.DiscountRowMapper;
import com.ride.rideapp.mappers.HolidayRowMapper;
import com.ride.rideapp.mappers.RideRowMapper;
import com.ride.rideapp.models.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DiscountCalculator {

    static JdbcTemplate conn;

    public float calculateDiscount(Offer offer) {

        int ride_id = offer.getRide_id();
        float price = offer.getPrice();

        String sql = "SELECT * FROM rides WHERE ride_id=" + ride_id;
        Ride ride = conn.query(sql, new RideRowMapper()).get(0);

        // if first ride --> discount 10%
        price = firstRideDiscount(price, ride);

        // if destination == discounted area --> rate% (rate = 10)
        price = discountedAreaDiscount(price, ride);

        // if at least 2 passengers --> 5% discount
        price = twoPassengersDiscount(price, ride);

        // if date == public holiday --> 5% discount
        price = holidayDiscount(price);

        // if user's birthday == today --> 10% discount
        price = birthdayDiscount(price, ride);

        return price;
    }

    private static float firstRideDiscount(float price, Ride ride) {

        int customer_id = ride.getCustomer_id();

        String sql = "SELECT * FROM rides WHERE customer_id=" + customer_id;
        List<Ride> all_customer_rides = conn.query(sql, new RideRowMapper());

        int number_of_rides = all_customer_rides.size();

        if (number_of_rides == 1)
            price = price - (price / 10);

        return price;
    }

    private static float discountedAreaDiscount(float price, Ride ride) {

        String destination = ride.getDestination();

        String sql = "SELECT * FROM discounts WHERE area_name='" + destination + "'";
        List<Discount> discounts = conn.query(sql, new DiscountRowMapper());

        if (!discounts.isEmpty()) {
            float rate = discounts.get(0).getRate();
            price = price - (price / rate);
        }

        return price;
    }

    private static float twoPassengersDiscount(float price, Ride ride) {
        int number_of_passengers = ride.getNumber_of_passengers();

        if (number_of_passengers >= 2)
            price = price - (price / 5);

        return price;
    }

    private static float holidayDiscount(float price) {
        Date today_date = new Date();
        DateFormat date_format = new SimpleDateFormat("MM-dd");
        String today = date_format.format(today_date);

        String sql = "SELECT * FROM holidays WHERE DATE_FORMAT(holiday_date, '%m-%d')=" + today + "'";
        List<Holiday> holidays = conn.query(sql, new HolidayRowMapper());

        if (!holidays.isEmpty())
            price = price - (price / 5);

        return price;
    }

    private static float birthdayDiscount(float price, Ride ride) {
        int customer_id = ride.getCustomer_id();
        Date today_date = new Date();
        DateFormat date_format = new SimpleDateFormat("MM-dd");
        String today = date_format.format(today_date);

        String sql = "SELECT customers.* " +
                     "FROM customers, offers " +
                     "WHERE offers.id=" + customer_id + " AND DATE_FORMAT(customers.birthdate, '%m-%d')='" + today + "'";

        List<Customer> customers = conn.query(sql, new CustomerRowMapper());

        if (!customers.isEmpty())
            price = price - (price / 10);

        return price;
    }
}
