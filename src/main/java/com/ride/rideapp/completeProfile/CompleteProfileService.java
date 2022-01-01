package com.ride.rideapp.completeProfile;

import com.ride.rideapp.models.Driver;

public interface CompleteProfileService {
    Driver complete_profile(int id, String national_id, String driver_license);
}
