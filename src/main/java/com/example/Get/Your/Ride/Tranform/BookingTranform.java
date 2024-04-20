package com.example.Get.Your.Ride.Tranform;

import com.example.Get.Your.Ride.DtoResponse.TripBookingResponse;
import com.example.Get.Your.Ride.DtoResquest.TripBookingRequest;
import com.example.Get.Your.Ride.Enums.TripStatus;
import com.example.Get.Your.Ride.Models.TripBooking;

import java.util.UUID;

public class BookingTranform {

        public static TripBooking bookingRequestToBooking(TripBookingRequest tripBookingRequest){

                    return  TripBooking.builder()
                            .BookingId(String.valueOf(UUID.randomUUID()))
                            .pikUp(tripBookingRequest.getPickUp())
                            .dropOff(tripBookingRequest.getDropOff())
                            .TripDistance(tripBookingRequest.getTripDistance())
                            .TripStatus(TripStatus.IN_TRANSACTION).build();
        }
        public  static TripBookingResponse bookingToBookingResponse(TripBooking tripBooking){

                    return TripBookingResponse.builder()
                            .BookingId(tripBooking.getBookingId())
                            .pikUp(tripBooking.getPikUp())
                            .dropOff(tripBooking.getDropOff())
                            .TripDistance(tripBooking.getTripDistance())
                            .TotalFare(tripBooking.getTotalFare())
                            .BookAt(tripBooking.getBookAt())
                            .tripStatus(tripBooking.getTripStatus())
                            .customerResponse(CustomerTranform.CustomerToCustomerResponse(tripBooking.getCustomers()))
                            .driverResponse(DriverTransform.driverResponse(tripBooking.getDriver())).build();
        }
}
