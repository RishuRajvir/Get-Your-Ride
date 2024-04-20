package com.example.Get.Your.Ride.Controller;

import com.example.Get.Your.Ride.Service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coupon")
public class CouponController {

        @Autowired
    CouponService couponService;

        @PostMapping
    public ResponseEntity<String> addCoupon(@RequestParam ("Coupon-Code")String coupon,
                                            @RequestParam("Percentage_Discount")Integer Discount){
                String response =couponService.addCoupon(coupon,Discount);
                return new ResponseEntity<>(response,HttpStatus.CREATED);
        }

}
