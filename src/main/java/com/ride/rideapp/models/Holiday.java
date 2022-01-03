package com.ride.rideapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Holiday {
    @Id
    int id;

    Date holiday_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHoliday_date() {
        return holiday_date;
    }

    public void setHoliday_date(Date holiday_date) {
        this.holiday_date = holiday_date;
    }
}
