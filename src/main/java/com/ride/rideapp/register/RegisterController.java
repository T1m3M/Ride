package com.ride.rideapp.register;

import com.ride.rideapp.models.Admin;
import com.ride.rideapp.models.Customer;
import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/admin")
    public Admin registerAdmin(
            @RequestParam(value="username") String username,
            @RequestParam(value="mobile") String mobile,
            @RequestParam(value="password") String password)  {
        return registerService.registerAdmin(username, mobile, password);
    }

    @PostMapping("/customer")
    public Customer registerCustomer(
            @RequestParam(value="username") String username,
            @RequestParam(value="mobile") String mobile,
            @RequestParam(value="password") String password,
            @RequestParam(value="birthdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthdate)  {
        return registerService.registerCustomer(username, mobile, password, birthdate);
    }

    @PostMapping("/driver")
    public Driver registerDriver(
            @RequestParam(value="username") String username,
            @RequestParam(value="mobile") String mobile,
            @RequestParam(value="password") String password,
            @RequestParam(value="national_id") String national_id,
            @RequestParam(value="driver_license") String driver_license,
            @RequestParam(value="seats_number") int seats_number)  {
        return registerService.registerDriver(username, mobile, password, national_id, driver_license, seats_number);
    }

}
