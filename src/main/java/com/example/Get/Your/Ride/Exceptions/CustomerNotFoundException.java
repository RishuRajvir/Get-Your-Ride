package com.example.Get.Your.Ride.Exceptions;

public class CustomerNotFoundException extends  RuntimeException{

            public CustomerNotFoundException(String message){
                super(message);
            }

}
