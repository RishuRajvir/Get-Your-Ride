package com.example.Get.Your.Ride.Tranform;

import com.example.Get.Your.Ride.DtoResponse.CustomerResponse;
import com.example.Get.Your.Ride.DtoResquest.CustomerRequests;
import com.example.Get.Your.Ride.Enums.TripStatus;
import com.example.Get.Your.Ride.Models.Customers;

public class CustomerTranform {

            public static Customers CustomerRequestToCustomer(CustomerRequests customerRequests){

                        return Customers.builder().name(customerRequests.getName())
                                .emailId(customerRequests.getEmail())
                                .gender(customerRequests.getGender())
                                .mobileNo(customerRequests.getMobileNo())
                                .build();
            }
            public static CustomerResponse CustomerToCustomerResponse(Customers customers){
                return CustomerResponse.builder()
                        .name(customers.getName())
                        .mobileNo(customers.getMobileNo())
                        .email(customers.getEmailId())
                        .build();
            }
}
