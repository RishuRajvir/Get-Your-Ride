package com.example.Get.Your.Ride.Tranform;

import com.example.Get.Your.Ride.DtoResquest.CabRequest;
import com.example.Get.Your.Ride.DtoResponse.CabResponse;
import com.example.Get.Your.Ride.Models.Cab;

public class CabTransform {

        public static Cab cabRequestToCab(CabRequest cabRequest){
                return Cab.builder()
                        .CabNo(cabRequest.getCabNo())
                        .FarePerks(cabRequest.getFarePerks())
                        .NoOfSeats(cabRequest.getNoOfSeats())
                        .CompanyName(cabRequest.getCompanyName())
                        .isAvailable(true)
                        .carType(cabRequest.getCarType()).build();
        }
        public static CabResponse cabToCabResponse(Cab cab){
                return CabResponse.builder()
                        .cabNo(cab.getCabNo())
                        .NoOfSeats(cab.getNoOfSeats())
                        .FarePerks(cab.getFarePerks()).carType(cab.getCarType().toString())
                        .build();
        }
}
