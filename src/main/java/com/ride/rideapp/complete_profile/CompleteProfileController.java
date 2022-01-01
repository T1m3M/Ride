package com.ride.rideapp.complete_profile;

import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/complete_profile")
public class CompleteProfileController {

    @Autowired
    private Driver driver;

    @PutMapping("/driver")
    public Driver registerDriver(
            @RequestParam(value="id") Integer id,
            @RequestParam(value="national_id") String national_id,
            @RequestParam(value="driver_license") String driver_license){
        return driver.complete_profile(id, national_id, driver_license);
    }
}
