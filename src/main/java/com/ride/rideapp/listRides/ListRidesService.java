package com.ride.rideapp.listRides;

import com.ride.rideapp.models.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListRidesService {

    @Autowired
    private ListRidesRepo listRidesRepo;

    public List<Ride> listRides(Integer driver_id) {
        return listRidesRepo.listRides(driver_id);
    }
}
