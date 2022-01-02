package com.ride.rideapp.listRides;

import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/driver")
public class ListRidesController {

    @Autowired
    private ListRidesService listRidesService;

    @GetMapping("/list_rides")
    public List<Ride> listRides(@RequestParam(value="driver_id") Integer driver_id) {
        return listRidesService.listRides(driver_id);
    }
}
