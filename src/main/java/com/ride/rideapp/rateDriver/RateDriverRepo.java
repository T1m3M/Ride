package com.ride.rideapp.rateDriver;

import com.ride.rideapp.mappers.DriverRowMapper;
import com.ride.rideapp.mappers.OfferRowMapper;
import com.ride.rideapp.mappers.RatingRowMapper;
import com.ride.rideapp.models.Driver;
import com.ride.rideapp.models.Offer;
import com.ride.rideapp.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RateDriverRepo {

    @Autowired
    JdbcTemplate conn;

    public Rating rateDriver(int ride_id, int rating) {

        if (rating < 1 || rating > 5) return null;

        String sql = "SELECT * FROM ratings WHERE ride_id=" + ride_id;
        List<Rating> result = conn.query(sql, new RatingRowMapper());

        if (result.isEmpty()) {
            // getting last rating id
            sql = "SELECT * FROM ratings ORDER BY id DESC LIMIT 1";
            result = conn.query(sql, new RatingRowMapper());

            int lastId = 0;
            if (!result.isEmpty()) lastId = result.get(0).getId();

            sql = "SELECT drivers.* FROM rides, offers, drivers WHERE rides.id=" + ride_id + " AND rides.offer_id=offers.id AND offers.driver_id=drivers.id";
            Driver driver = conn.query(sql, new DriverRowMapper()).get(0);

            int driver_id = driver.getId();

            // saving rating object
            Rating rating_entity = new Rating();
            rating_entity.setId(lastId + 1);
            rating_entity.setRide_id(ride_id);
            rating_entity.setDriver_id(driver_id);
            rating_entity.setRating(rating);

            sql = "INSERT INTO ratings(id, ride_id, driver_id, rating) VALUES(?, ?, ?, ?)";
            conn.update(
                    sql,
                    rating_entity.getId(),
                    rating_entity.getRide_id(),
                    rating_entity.getDriver_id(),
                    rating_entity.getRating()
            );

            // update average rating of driver
            float current_rating = driver.getAverage_rating();

            sql = "SELECT * FROM ratings WHERE driver_id=" + driver_id;
            List<Rating> ratings = conn.query(sql, new RatingRowMapper());

            int number_of_ratings = ratings.size();
            float new_average_rating = (current_rating + rating) / number_of_ratings;

            sql = "UPDATE drivers SET average_rating=? WHERE id=" + driver_id;
            conn.update(sql, new_average_rating);

            return rating_entity;

        }

        return null;
    }
}
