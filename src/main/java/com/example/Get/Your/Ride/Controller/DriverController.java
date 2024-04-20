package com.example.Get.Your.Ride.Controller;


import com.example.Get.Your.Ride.DtoResquest.DriverRequest;
import com.example.Get.Your.Ride.DtoResponse.DriverResponse;
import com.example.Get.Your.Ride.Models.Driver;
import com.example.Get.Your.Ride.Service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

            @Autowired
            DriverService driverService;


            @PostMapping
            public ResponseEntity<DriverResponse> addDriver(@RequestBody DriverRequest driverRequest){
                DriverResponse driverResponse = driverService.addDriver(driverRequest);
                return  new ResponseEntity<>(driverResponse, HttpStatus.CREATED);
            }
            @DeleteMapping
            public  String delete(@RequestBody DriverRequest driverRequest){
                return driverService.deleteDriver(driverRequest);
            }
            @GetMapping
        public List<Driver> getDriversOfHighestRating(){
                return driverService.getDrivers();
            }
            @PutMapping
    public String updateRating(@RequestParam("rating")double rating,
                               @RequestParam("mobileNo")String mobileNo){

                String result = driverService.update(rating,mobileNo);
                return result;
            }

}
