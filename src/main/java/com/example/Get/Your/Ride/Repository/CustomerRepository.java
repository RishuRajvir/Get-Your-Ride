package com.example.Get.Your.Ride.Repository;


import com.example.Get.Your.Ride.Models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customers,Integer> {

            @Query(value = "Select * from customers where gender = :g ",nativeQuery = true)
            List<Customers> findByGender(String g);

//        @Query(value = "Select c from customers c where c.gender = :g ",nativeQuery = true);
//        List<Customers> getByGender(String g);

          Customers findByEmailId(String EmailId);


}
