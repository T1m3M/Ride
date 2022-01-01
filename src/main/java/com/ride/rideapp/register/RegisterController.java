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
            @RequestParam(value="password") String password)  {
        return registerService.registerCustomer(username, mobile, password);
    }

    @PostMapping("/driver")
    public Driver registerDriver(
            @RequestParam(value="username") String username,
            @RequestParam(value="mobile") String mobile,
            @RequestParam(value="password") String password)  {
        return registerService.registerDriver(username, mobile, password);
    }

}
