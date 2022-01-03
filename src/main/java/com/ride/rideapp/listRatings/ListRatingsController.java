package com.ride.rideapp.listRatings;

import com.ride.rideapp.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/driver")
public class ListRatingsController {

    @Autowired
    private ListRatingsService listRatingsService;

    @GetMapping("/list_ratings")
    public List<Rating> listRatings(@RequestParam(value="driver_id") Integer driver_id) {
        return listRatingsService.listRatings(driver_id);
    }
}
