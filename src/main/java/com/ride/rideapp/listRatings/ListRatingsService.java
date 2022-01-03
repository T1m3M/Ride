package com.ride.rideapp.listRatings;

import com.ride.rideapp.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListRatingsService {

    @Autowired
    private ListRatingsRepo listRatingsRepo;

    public List<Rating> listRatings(Integer driver_id) {
        return listRatingsRepo.listRatings(driver_id);
    }
}
