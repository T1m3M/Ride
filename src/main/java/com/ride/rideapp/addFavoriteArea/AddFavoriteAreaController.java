package com.ride.rideapp.addFavoriteArea;

import com.ride.rideapp.models.FavoriteArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/driver")
public class AddFavoriteAreaController {

    @Autowired
    AddFavoriteAreaService addFavoriteAreaService;

    @PostMapping("/add_favorite_area")
    public FavoriteArea addFavoriteArea(
            @RequestParam(value="driver_id") Integer driver_id,
            @RequestParam(value="area_name") String area_name
    ) {
        return addFavoriteAreaService.addArea(driver_id, area_name);
    }
}
