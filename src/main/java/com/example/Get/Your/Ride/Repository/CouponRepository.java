package com.example.Get.Your.Ride.Repository;

import com.example.Get.Your.Ride.Models.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Integer> {



        Coupon findByCouponCode(String coupon);
}
