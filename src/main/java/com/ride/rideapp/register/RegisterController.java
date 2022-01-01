package com.ride.rideapp.register;

import com.ride.rideapp.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private Admin admin;

    @GetMapping("/admin")
    public Admin registerAdmin(
            @RequestParam(value="username") String username,
            @RequestParam(value="mobile") String mobile,
            @RequestParam(value="password") String password)  {
        return admin.register(username, mobile, password);
    }

}
