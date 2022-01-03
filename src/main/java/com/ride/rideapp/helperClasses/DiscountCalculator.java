package com.ride.rideapp.helperClasses;

import com.ride.rideapp.mappers.CustomerRowMapper;
import com.ride.rideapp.mappers.DiscountRowMapper;
import com.ride.rideapp.mappers.HolidayRowMapper;
import com.ride.rideapp.mappers.RideRowMapper;
import com.ride.rideapp.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class DiscountCalculator {

    @Autowired
    JdbcTemplate conn;

    public float calculateDiscount(Offer offer) {

        int ride_id = offer.getRide_id();
        float price = offer.getPrice();
        float total_discount = 0;

        String sql = "SELECT * FROM rides WHERE id=" + ride_id;
        Ride ride = conn.query(sql, new RideRowMapper()).get(0);

        // if first ride --> discount 10%
        total_discount += firstRideDiscount(ride.getCustomer_id());

        // if destination == discounted area --> rate% (rate = 10)
        total_discount += discountedAreaDiscount(ride.getDestination());

        // if at least 2 passengers --> 5% discount
        total_discount += twoPassengersDiscount(ride.getNumber_of_passengers());

        // if date == public holiday --> 5% discount
        total_discount += holidayDiscount();

        // if user's birthday == today --> 10% discount
        total_discount += birthdayDiscount(ride.getCustomer_id());

        if (total_discount != 0)
            price = price - (price * total_discount / 100);

        return price;
    }

    private float firstRideDiscount(int customer_id) {
        String sql = "SELECT * FROM rides WHERE customer_id=" + customer_id;
        List<Ride> all_customer_rides = conn.query(sql, new RideRowMapper());

        int number_of_rides = all_customer_rides.size();

        if (number_of_rides == 1)
            return 10;

        return 0;
    }

    private float discountedAreaDiscount(String destination) {
        String sql = "SELECT * FROM discounts WHERE area_name='" + destination + "'";
        List<Discount> discounts = conn.query(sql, new DiscountRowMapper());

        if (!discounts.isEmpty())
            return discounts.get(0).getRate();

        return 0;
    }

    private float twoPassengersDiscount(int number_of_passengers) {
        if (number_of_passengers >= 2)
            return 5;

        return 0;
    }

    private float holidayDiscount() {
        Date today_date = new Date();
        DateFormat date_format = new SimpleDateFormat("MM-dd");
        String today = date_format.format(today_date);

        String sql = "SELECT * FROM holidays WHERE DATE_FORMAT(holiday_date, '%m-%d')='" + today + "'";
        List<Holiday> holidays = conn.query(sql, new HolidayRowMapper());

        if (!holidays.isEmpty())
            return 5;

        return 0;
    }

    private float birthdayDiscount(int ride_id) {
        Date today_date = new Date();
        DateFormat date_format = new SimpleDateFormat("MM-dd");
        String today = date_format.format(today_date);

        String sql = "SELECT customers.* " +
                     "FROM customers, rides " +
                     "WHERE rides.customer_id=" + ride_id + " AND DATE_FORMAT(customers.birthdate, '%m-%d')='" + today + "'";

        List<Customer> customers = conn.query(sql, new CustomerRowMapper());

        if (!customers.isEmpty())
            return 10;

        return 0;
    }
}
