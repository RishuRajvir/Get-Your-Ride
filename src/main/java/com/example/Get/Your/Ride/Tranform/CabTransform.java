package com.example.Get.Your.Ride.Tranform;

import com.example.Get.Your.Ride.DtoResquest.CabRequest;
import com.example.Get.Your.Ride.DtoResponse.CabResponse;
import com.example.Get.Your.Ride.Models.Cab;

public class CabTransform {

        public static Cab cabRequestToCab(CabRequest cabRequest){
                return Cab.builder()
                        .cabNo(cabRequest.getCabNo())
                        .farePerks(cabRequest.getFarePerks())
                        .noOfSeats(cabRequest.getNoOfSeats())
                        .companyName(cabRequest.getCompanyName())
                        .isAvailable(true)
                        .carType(cabRequest.getCarType()).build();
        }
        public static CabResponse cabToCabResponse(Cab cab){
                return CabResponse.builder()
                        .cabNo(cab.getCabNo())
                        .noOfSeats(cab.getNoOfSeats())
                        .farePerks(cab.getFarePerks())
                        .carType(cab.getCarType().toString())
                        .build();
        }
}
