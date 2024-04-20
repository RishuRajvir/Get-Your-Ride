package com.example.Get.Your.Ride.DtoResquest;


import com.example.Get.Your.Ride.Enums.CarType;
import com.example.Get.Your.Ride.Models.Cab;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Builder
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CabRequest {
    String cabNo;

    String companyName;

    CarType carType;

    Integer noOfSeats;

    Integer farePerks;



}
