package com.ride.rideapp.login;

import com.ride.rideapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/admin")
    public User loginAdmin(@RequestParam(value="mobile") String mobile,
                            @RequestParam(value="password") String password)  {
        return userRepo.loginUser(mobile, password);
    }
}
