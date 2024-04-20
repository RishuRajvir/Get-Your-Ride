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
    String BookingId;

    String pikUp;

    String dropOff;

    double TripDistance;

    double TotalFare;

   @Enumerated(value = EnumType.STRING)
    TripStatus tripStatus;

    Date BookAt;

   CustomerResponse customerResponse;

   DriverResponse driverResponse;

}
