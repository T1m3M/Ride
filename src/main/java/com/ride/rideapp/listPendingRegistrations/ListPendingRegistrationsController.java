package com.ride.rideapp.listPendingRegistrations;

import com.ride.rideapp.models.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin")
public class ListPendingRegistrationsController {

    @Autowired
    private ListPendingRegistrationsService listPendingRegistrationsService;

    @GetMapping("/list_pending_registrations")
    public List<Driver> registerDriver(){
        return listPendingRegistrationsService.listPendingRegistrations();
    }
}
