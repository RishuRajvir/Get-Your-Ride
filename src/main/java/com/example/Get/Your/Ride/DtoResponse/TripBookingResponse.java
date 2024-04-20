package com.example.Get.Your.Ride.DtoResponse;

import com.example.Get.Your.Ride.Enums.TripStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripBookingResponse {
    String bookingId;

    String pikUp;

    String dropOff;

    double tripDistance;

    double totalFare;

   @Enumerated(value = EnumType.STRING)
    TripStatus tripStatus;

    Date bookAt;

   CustomerResponse customerResponse;

   DriverResponse driverResponse;

}
