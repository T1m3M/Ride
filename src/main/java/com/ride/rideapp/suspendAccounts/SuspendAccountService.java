package com.ride.rideapp.suspendAccounts;

import com.ride.rideapp.models.Customer;
import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuspendAccountService {

    @Autowired
    private SuspendAccountRepo suspendAccountRepo;

    public Customer suspendCustomer(int id) {
        return suspendAccountRepo.suspendCustomer(id);
    }

    public Driver suspendDriver(int id) {
        return suspendAccountRepo.suspendDriver(id);
    }
}
