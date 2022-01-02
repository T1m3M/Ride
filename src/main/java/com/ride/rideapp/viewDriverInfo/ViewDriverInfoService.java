package com.ride.rideapp.viewDriverInfo;

import com.ride.rideapp.models.DriverInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewDriverInfoService {

    @Autowired
    ViewDriverInfoRepo viewDriverInfoRepo;

    public DriverInfo viewDriverInfo(Integer driver_id) {
        return viewDriverInfoRepo.viewDriverInfo(driver_id);
    }
}
