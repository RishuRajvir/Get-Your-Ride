package com.example.Get.Your.Ride.Service;

import com.example.Get.Your.Ride.Models.Coupon;
import com.example.Get.Your.Ride.Repository.CouponRepository;
import com.example.Get.Your.Ride.Tranform.CouponTranform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {

        @Autowired
    CouponRepository couponRepository;
    public String addCoupon(String couponCode, Integer discount) {

        Coupon coupon = CouponTranform.prepareCoupon(couponCode,discount);
        couponRepository.save(coupon);
        return "Coupon added successfully!!";
    }
}
