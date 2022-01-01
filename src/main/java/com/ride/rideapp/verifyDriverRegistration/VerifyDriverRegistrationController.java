package com.ride.rideapp.verifyDriverRegistration;

import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class VerifyDriverRegistrationController {

    @Autowired
    private VerifyDriverRegistrationService verifyDriverRegistrationService;

    @PutMapping("/verify_driver_registration")
    public Driver verifyDriver(@RequestParam(value="id") Integer id){
        return verifyDriverRegistrationService.verifyDriver(id);
    }
}