package com.example.Get.Your.Ride.Tranform;

import com.example.Get.Your.Ride.Models.Coupon;

public class CouponTranform {
    public static Coupon prepareCoupon(String coupon, Integer discount) {
                    return Coupon.builder().couponCode(coupon).discount(discount).build();
    }
}
