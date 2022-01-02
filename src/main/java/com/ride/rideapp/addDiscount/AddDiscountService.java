package com.ride.rideapp.addDiscount;

import com.ride.rideapp.models.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddDiscountService {

    @Autowired
    AddDiscountRepo addDiscountRepo;

    public Discount addDiscount(String area_name) {
        return addDiscountRepo.addDiscount(area_name);
    }
}
