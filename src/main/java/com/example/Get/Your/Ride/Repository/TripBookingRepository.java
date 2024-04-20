package com.example.Get.Your.Ride.Repository;

import com.example.Get.Your.Ride.Models.TripBooking;
import com.example.Get.Your.Ride.Service.TripBookingService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripBookingRepository extends JpaRepository<TripBooking,Integer> {

//    TripBooking findByMobileNo(String mobileNo);
}
