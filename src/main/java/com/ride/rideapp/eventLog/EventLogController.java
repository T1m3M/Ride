package com.ride.rideapp.eventLog;

import com.ride.rideapp.models.AcceptOfferEvent;
import com.ride.rideapp.models.OfferEvent;
import com.ride.rideapp.models.TrackRideEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/event")
public class EventLogController {

    @Autowired
    EventLogService eventLogService;

    @GetMapping("/show_offer")
    public OfferEvent showOffer(@RequestParam("ride_id") Integer ride_id) {

        return eventLogService.showOffer(ride_id);
    }

    @GetMapping("/offer_accept")
    public AcceptOfferEvent offerAccept(@RequestParam("ride_id") Integer ride_id) {

        return eventLogService.offerAccept(ride_id);
    }

    @GetMapping("/ride_start")
    public TrackRideEvent rideStart(@RequestParam("ride_id") Integer ride_id) {

        return eventLogService.rideStart(ride_id);
    }

    @GetMapping("/ride_end")
    public TrackRideEvent rideEnd(@RequestParam("ride_id") Integer ride_id) {

        return eventLogService.rideEnd(ride_id);
    }

}
