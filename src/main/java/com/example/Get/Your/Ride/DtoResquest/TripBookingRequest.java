package com.example.Get.Your.Ride.DtoResquest;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripBookingRequest {

            String pickUp;
            String dropOff;

             double tripDistance;

             String customerEmail;

}
