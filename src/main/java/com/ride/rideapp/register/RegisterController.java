package com.ride.rideapp.register;

import com.ride.rideapp.models.Admin;
import com.ride.rideapp.models.Customer;
import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private Admin admin;

    @Autowired
    private Customer customer;

    @Autowired
    private Driver driver;

    @PostMapping("/admin")
    public Admin registerAdmin(
            @RequestParam(value="username") String username,
            @RequestParam(value="mobile") String mobile,
            @RequestParam(value="password") String password)  {
        return admin.register(username, mobile, password);
    }

    @PostMapping("/customer")
    public Customer registerCustomer(
            @RequestParam(value="username") String username,
            @RequestParam(value="mobile") String mobile,
            @RequestParam(value="password") String password)  {
        return customer.register(username, mobile, password);
    }

    @PostMapping("/driver")
    public Driver registerDriver(
            @RequestParam(value="username") String username,
            @RequestParam(value="mobile") String mobile,
            @RequestParam(value="password") String password)  {
        return driver.register(username, mobile, password);
    }

}
