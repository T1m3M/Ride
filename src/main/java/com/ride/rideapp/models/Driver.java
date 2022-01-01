package com.ride.rideapp.models;

import com.ride.rideapp.completeProfile.CompleteProfileRepo;
import com.ride.rideapp.completeProfile.CompleteProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Driver extends User implements CompleteProfileService {
    private boolean account_status;
    String national_id, driver_license;
    float average_rating;
    boolean verification_status;

    @Autowired
    CompleteProfileRepo completeProfileRepo;

    @Override
    public Driver login(String mobile, String password) {
        return loginRepo.loginDriver(mobile, password);
    }


    @Override
    public Driver register(String username,
                           String mobile,
                           String password) {
        return registerRepo.registerDriver(username, mobile, password);
    }

    @Override
    public Driver complete_profile(int id, String national_id, String driver_license) {
        return completeProfileRepo.completeProfile(id, national_id, driver_license);
    }

    public boolean getAccount_status() {
        return account_status;
    }

    public void setAccount_status(boolean account_status) {
        this.account_status = account_status;
    }

    public String getNational_id() {
        return national_id;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
    }

    public String getDriver_license() {
        return driver_license;
    }

    public void setDriver_license(String driver_license) {
        this.driver_license = driver_license;
    }

    public float getAverage_rating() {
        return average_rating;
    }

    public void setAverage_rating(float average_rating) {
        this.average_rating = average_rating;
    }

    public boolean getVerification_status() {
        return verification_status;
    }

    public void setVerification_status(boolean verification_status) {
        this.verification_status = verification_status;
    }
}
