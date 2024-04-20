package com.example.Get.Your.Ride.Exceptions;

public class CabNotAvailableException extends RuntimeException{
        public  CabNotAvailableException (String message){
            super(message);
        }
}
