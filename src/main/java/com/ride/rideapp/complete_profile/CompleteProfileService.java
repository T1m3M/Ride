package com.ride.rideapp.complete_profile;

import com.ride.rideapp.models.Driver;

public interface CompleteProfileService {
    Driver complete_profile(int id, String national_id, String driver_license);
}
