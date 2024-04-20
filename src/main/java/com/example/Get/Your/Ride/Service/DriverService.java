package com.example.Get.Your.Ride.Service;

import com.example.Get.Your.Ride.DtoResquest.DriverRequest;
import com.example.Get.Your.Ride.DtoResponse.DriverResponse;
import com.example.Get.Your.Ride.Models.Cab;
import com.example.Get.Your.Ride.Models.Driver;
import com.example.Get.Your.Ride.Repository.DriverRepository;
import com.example.Get.Your.Ride.Tranform.CabTransform;
import com.example.Get.Your.Ride.Tranform.DriverTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

        @Autowired
        DriverRepository driverRepository;

        public DriverResponse addDriver(DriverRequest driverRequest){

              // Create Entity from Requests of Driver and Cab
               Driver driver = DriverTransform.driverRequestToDriver(driverRequest);
               Cab cab = CabTransform.cabRequestToCab(driverRequest.getCabRequest());


                //Set Each Entity
                driver.setCab(cab);
                cab.setDriver(driver);

              // SAVE Driver Entity CAB will be Saved because its mapped by driver
              Driver savedDriver =  driverRepository.save(driver);

              return DriverTransform.driverResponse(savedDriver);
//                      DriverResponse.builder()
//                        .name(savedDriver.getName())
//                        .MobileNo(savedDriver.getMobileNo())
//                        .CabNo(savedDriver.getCab().getCabNo()).rating(savedDriver.getRating())
//                        .build();
              // HERE WE ARE RETURN DRIVER RESPONSE
        }
        public String deleteDriver(DriverRequest driverRequest){
            String mobileNoNo = driverRequest.getMobileNo();
            Driver driver = driverRepository.findByMobileNo(mobileNoNo);
            Cab cab = driver.getCab();
            driverRepository.delete(driver);

            return "The Driver Has Been Deleted";
        }
        public Driver getDriver(String MobNo){
           return driverRepository.findByMobileNo(MobNo);
        }

    public List<Driver> getDrivers() {
        return driverRepository.findByRating();
    }

    public String update(double rating, String mobileNo) {
            Driver driver = driverRepository.findByMobileNo(mobileNo);
            driver.setRating(rating);
            driverRepository.save(driver);
            return "Rating has been Updated";
    }
}
