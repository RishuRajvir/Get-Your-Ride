package com.example.Get.Your.Ride.Repository;

import com.example.Get.Your.Ride.Models.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepository extends JpaRepository<Cab,Integer> {


    @Query(value = "select * from cabs where is_available = true order by rand() limit 1",nativeQuery = true)
    Cab getRandomAvailableCab();
}
