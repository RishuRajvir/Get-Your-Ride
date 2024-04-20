package com.example.Get.Your.Ride.DtoResquest;


import com.example.Get.Your.Ride.Enums.Gender;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerRequests {
    String mobileNo;
    String email;
    String name;
    Gender gender;
}
