package com.ride.rideapp.addFavoriteArea;

import com.ride.rideapp.models.FavoriteArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddFavoriteAreaService {

    @Autowired
    AddFavoriteAreaRepo addFavoriteAreaRepo;

    public FavoriteArea addArea(int driver_id, String area_name) {
        return addFavoriteAreaRepo.addArea(driver_id, area_name);
    }
}
