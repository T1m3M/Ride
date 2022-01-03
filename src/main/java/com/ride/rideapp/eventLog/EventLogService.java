package com.ride.rideapp.eventLog;

import com.ride.rideapp.models.AcceptOfferEvent;
import com.ride.rideapp.models.Event;
import com.ride.rideapp.models.OfferEvent;
import com.ride.rideapp.models.TrackRideEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventLogService {

    @Autowired
    EventLogRepo eventLogRepo;

    public OfferEvent showOffer(int ride_id) {
        return eventLogRepo.showOffer(ride_id);
    }

    public AcceptOfferEvent offerAccept(int ride_id) {
        return eventLogRepo.offerAccept(ride_id);
    }

    public TrackRideEvent rideStart(int ride_id) {
        return eventLogRepo.rideStart(ride_id);
    }

    public TrackRideEvent rideEnd(int ride_id) {
        return eventLogRepo.rideEnd(ride_id);
    }
}
