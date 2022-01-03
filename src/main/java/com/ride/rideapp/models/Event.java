package com.ride.rideapp.models;

import java.sql.Timestamp;

public abstract class Event {
    String event_name;
    Timestamp event_time;

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public Timestamp getEvent_time() {
        return event_time;
    }

    public void setEvent_time(Timestamp event_time) {
        this.event_time = event_time;
    }
}
