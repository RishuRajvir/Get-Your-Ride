package com.example.Get.Your.Ride.Tranform;

import com.example.Get.Your.Ride.DtoResquest.DriverRequest;
import com.example.Get.Your.Ride.DtoResponse.DriverResponse;
import com.example.Get.Your.Ride.Models.Driver;

public class DriverTransform {
    public static Driver driverRequestToDriver(DriverRequest driverRequest) {

        // Create Entity from Requests of Driver and Cab
        return Driver.builder()
                .name(driverRequest.getName())
                .mobileNo(driverRequest.getMobileNo())
                .rating(driverRequest.getRating()).build();
    }
    public static DriverResponse driverResponse(Driver driver){
        return DriverResponse.builder()
                .name(driver.getName())
                .rating(driver.getRating())
                .MobileNo(driver.getMobileNo())
                .cabResponse(CabTransform.cabToCabResponse(driver.getCab()))
                .build();
    }
}
