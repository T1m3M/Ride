package com.ride.rideapp.suspendAccounts;

import com.ride.rideapp.models.Customer;
import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class SuspendAccountController {

    @Autowired
    private SuspendAccountService suspendAccountService;

    @PutMapping("/suspend_customer")
    public Customer suspendCustomer(@RequestParam(value="id") Integer id){
        return suspendAccountService.suspendCustomer(id);
    }

    @PutMapping("/suspend_driver")
    public Driver suspendDriver(@RequestParam(value="id") Integer id){
        return suspendAccountService.suspendDriver(id);
    }

}
