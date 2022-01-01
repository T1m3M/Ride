package com.ride.rideapp.listPendingRegistrations;

import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListPendingRegistrationsService {

    @Autowired
    private ListPendingRegistrationsRepo listPendingRegistrationsRepo;

    public List<Driver> listPendingRegistrations() {
        return listPendingRegistrationsRepo.listAll();
    }
}
