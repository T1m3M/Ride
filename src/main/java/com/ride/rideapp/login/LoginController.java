package com.ride.rideapp.login;

import com.ride.rideapp.models.Admin;
import com.ride.rideapp.models.Customer;
import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/admin")
    public Admin loginAdmin(@RequestParam(value="mobile") String mobile,
                                 @RequestParam(value="password") String password)  {
        return loginService.loginAdmin(mobile, password);
    }

    @GetMapping("/customer")
    public Customer loginCustomer(@RequestParam(value="mobile") String mobile,
                            @RequestParam(value="password") String password)  {
        return loginService.loginCustomer(mobile, password);
    }

    @GetMapping("/driver")
    public Driver loginDriver(@RequestParam(value="mobile") String mobile,
                              @RequestParam(value="password") String password)  {
        return loginService.loginDriver(mobile, password);
    }
}
