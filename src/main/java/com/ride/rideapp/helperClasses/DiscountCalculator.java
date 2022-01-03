package com.ride.rideapp.helperClasses;

import com.ride.rideapp.models.Offer;

public class DiscountCalculator {

    public static float calculateDiscount(Offer offer) {

        float price = offer.getPrice();

        // if first ride --> discount 10%
        price = firstRideDiscount(price, offer);

        // if destination == discounted area --> rate% (rate = 10)
        price = discountedAreaDiscount(price, offer);

        // if 2 passengers --> 5% discount
        price = twoPassengersDiscount(price, offer);

        // if date == public holiday --> 5% discount
        price = holidayDiscount(price, offer);

        // if user's birthday == today --> 10% discount
        price = birthdayDiscount(price, offer);

        return price;
    }

    private static float firstRideDiscount(float price, Offer offer) {
        return 0.0F;
    }

    private static float discountedAreaDiscount(float price, Offer offer) {
        return 0.0F;
    }

    private static float twoPassengersDiscount(float price, Offer offer) {
        return 0.0F;
    }

    private static float holidayDiscount(float price, Offer offer) {
        return 0.0F;
    }

    private static float birthdayDiscount(float price, Offer offer) {
        return 0.0F;
    }
}
