package com.example.Get.Your.Ride.Repository;

import com.example.Get.Your.Ride.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {

            Driver findByMobileNo(String mobileNo);

            @Query(value = "select * from drivers order by rating desc",nativeQuery = true)
            List<Driver> findByRating();
}
