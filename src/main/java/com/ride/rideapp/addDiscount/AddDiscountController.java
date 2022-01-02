package com.ride.rideapp.addDiscount;

import com.ride.rideapp.models.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/admin")
public class AddDiscountController {

    @Autowired
    AddDiscountService addDiscountService;

    @PostMapping("/add_discount")
    public Discount addDiscount(@RequestParam("area_name") String area_name) {
        return addDiscountService.addDiscount(area_name);
    }
}
