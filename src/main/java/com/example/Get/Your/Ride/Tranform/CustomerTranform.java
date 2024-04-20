package com.example.Get.Your.Ride.Tranform;

import com.example.Get.Your.Ride.DtoResponse.CustomerResponse;
import com.example.Get.Your.Ride.DtoResquest.CustomerRequests;
import com.example.Get.Your.Ride.Models.Customers;

public class CustomerTranform {

            public static Customers CustomerRequestToCustomer(CustomerRequests customerRequests){

                        return Customers.builder().name(customerRequests.getName())
                                .emailId(customerRequests.getEmail())
                                .gender(customerRequests.getGender())
                                .MobileNo(customerRequests.getMobileNo()).build();
            }
            public static CustomerResponse CustomerToCustomerResponse(Customers customers){
                return CustomerResponse.builder()
                        .name(customers.getName())
                        .MobileNo(customers.getMobileNo())
                        .email(customers.getEmailId())
                        .build();
            }
}
