package com.example.Get.Your.Ride.Controller;

import com.example.Get.Your.Ride.DtoResponse.CustomerResponse;
import com.example.Get.Your.Ride.DtoResponse.TripBookingResponse;
import com.example.Get.Your.Ride.DtoResquest.TripBookingRequest;
import com.example.Get.Your.Ride.Service.TripBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tripBook")
public class TripBookingController {

     private final TripBookingService tripBookingService;

    public TripBookingController(TripBookingService tripBookingService) {
        this.tripBookingService = tripBookingService;
    }

    @PostMapping("/book")
    public ResponseEntity<TripBookingResponse> bookCab(@RequestParam(value = "coupon",
                required = false,defaultValue = "false")String coupon,
            @RequestBody TripBookingRequest tripBookingRequest){
            TripBookingResponse response = tripBookingService.bookCab(coupon,tripBookingRequest);
            return new ResponseEntity<TripBookingResponse>(response, HttpStatus.CREATED);
    }
    @GetMapping("/cancel/{emailId}")
    public CustomerResponse cancelCab(@PathVariable String emailId , @RequestParam(value = "No.ofBooking",required = false)
                            Integer no ){
            return tripBookingService.cancelTrip(emailId,no);
    }

}
