package com.example.Get.Your.Ride.DtoResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CabResponse {

    String cabNo;

    String carType;

    Integer noOfSeats;

    double farePerks;
}
