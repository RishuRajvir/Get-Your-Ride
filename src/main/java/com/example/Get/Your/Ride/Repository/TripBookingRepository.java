package com.example.Get.Your.Ride.Repository;

import com.example.Get.Your.Ride.Models.TripBooking;
import com.example.Get.Your.Ride.Service.TripBookingService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TripBookingRepository extends JpaRepository<TripBooking,Integer> {




//    TripBooking findByPikUpAndDropOff(String pikup, String dropOff);


    @Query(value = "Select * from trip_booking where booking_id = :id ",nativeQuery = true)
    TripBooking findByID(String id);

//    TripBooking findByMobileNo(String mobileNo);
}
