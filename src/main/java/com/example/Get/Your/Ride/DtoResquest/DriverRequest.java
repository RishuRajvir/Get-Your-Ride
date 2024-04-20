package com.example.Get.Your.Ride.DtoResquest;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverRequest {

    String name;

    String MobileNo;

    double rating;

    CabRequest cabRequest;

}
