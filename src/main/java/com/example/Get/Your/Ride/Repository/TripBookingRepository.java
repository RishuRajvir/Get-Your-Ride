package com.example.Get.Your.Ride.Repository;

import com.example.Get.Your.Ride.Models.TripBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripBookingRepository extends JpaRepository<TripBooking,Integer> {
}
