package com.example.Get.Your.Ride.Controller;


import com.example.Get.Your.Ride.DtoResquest.CustomerRequests;
import com.example.Get.Your.Ride.DtoResponse.CustomerResponse;
import com.example.Get.Your.Ride.Models.Customers;
import com.example.Get.Your.Ride.Service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

//            @Autowired
//            CustomerService customerService;

      //Field Injection
        private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {

        this.customerService = customerService;
    }

         // Here we cannot write end point because we know what we are doing
            @PostMapping
            public ResponseEntity<CustomerResponse>addCustomer(@RequestBody CustomerRequests customerRequests){
                // Send it to Service Layer
                CustomerResponse customerResponse = customerService.addCustomer(customerRequests);
                return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);

            }
            @GetMapping("/gender/{gender}")
            public List<CustomerResponse> getCustomers(@RequestParam("gender")String gender){
                return  customerService.findCustomers(gender);
            }

}
