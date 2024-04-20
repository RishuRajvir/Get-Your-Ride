package com.example.Get.Your.Ride.DtoResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverResponse {

            String name;

            String mobileNo;

            double rating;

            CabResponse cabResponse;

}
