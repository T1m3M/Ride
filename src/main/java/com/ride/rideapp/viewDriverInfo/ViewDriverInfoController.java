package com.ride.rideapp.viewDriverInfo;

import com.ride.rideapp.models.DriverInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer")
public class ViewDriverInfoController {

    @Autowired
    ViewDriverInfoService viewDriverInfoService;

    @GetMapping("view_driver_info")
    public DriverInfo viewDriverInfo(@RequestParam(value="driver_id") Integer driver_id) {
        return viewDriverInfoService.viewDriverInfo(driver_id);
    }

}
