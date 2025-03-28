package com.example.Get.Your.Ride.Service;

import com.example.Get.Your.Ride.DtoResponse.CustomerResponse;
import com.example.Get.Your.Ride.DtoResponse.TripBookingResponse;
import com.example.Get.Your.Ride.DtoResquest.TripBookingRequest;
import com.example.Get.Your.Ride.Enums.TripStatus;
import com.example.Get.Your.Ride.Exceptions.CabNotAvailableException;
import com.example.Get.Your.Ride.Exceptions.CustomerNotFoundException;
import com.example.Get.Your.Ride.Models.Cab;
import com.example.Get.Your.Ride.Models.Coupon;
import com.example.Get.Your.Ride.Models.Customers;
import com.example.Get.Your.Ride.Models.TripBooking;
import com.example.Get.Your.Ride.Repository.*;
import com.example.Get.Your.Ride.Tranform.BookingTranform;
import com.example.Get.Your.Ride.Tranform.CustomerTranform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TripBookingService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    TripBookingRepository tripBookingRepository;

    @Autowired
    DriverRepository driverRepository;
    @Autowired
    CouponRepository couponRepository;

    private  final JavaMailSender javaMailSender;

    public TripBookingService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public TripBookingResponse bookCab(String coupon, TripBookingRequest tripBookingRequest) {

        double val = 0;
        Coupon coupon1 = couponRepository.findByCouponCode(coupon);
        if(coupon1 != null) {
            val = ((double) coupon1.getDiscount())/100;

        }
        Customers customers = customerRepository.findByEmailId(tripBookingRequest.getCustomerEmail());
            if(customers == null)
            {
                throw  new CustomerNotFoundException("Invalid Email Id");
            }
            Cab cab = cabRepository.getRandomAvailableCab();
            if(cab == null){
                throw  new CabNotAvailableException("All Drivers are Busy Now");
            }
        TripBooking tripBooking = BookingTranform.bookingRequestToBooking(tripBookingRequest);
            double total =  val;

        if(coupon1 != null)
            tripBooking.setTotalFare((cab.getFarePerks() * tripBooking.getTripDistance())*val);
        else
            tripBooking.setTotalFare((cab.getFarePerks() * tripBooking.getTripDistance()));



        tripBooking.setCustomers(customers);
        tripBooking.setDriver(cab.getDriver());

        TripBooking savedTripBooking = tripBookingRepository.save(tripBooking);

        customers.getTripBookings().add(savedTripBooking);
        cab.setAvailable(false);

        cab.getDriver().getTripBookings().add(savedTripBooking);

        customerRepository.save(customers);
        driverRepository.save(cab.getDriver());

        //Send Email to User
        sendMail(tripBooking);

        return BookingTranform.bookingToBookingResponse(savedTripBooking);
    }

    private void sendMail(TripBooking tripBooking) {
        Random random = new Random();
        int otp = 1000 + random.nextInt(9000);
            String text = "Dear "+tripBooking.getCustomers().getName()+" Your " +
                    "cab has been booked successfully with "+ tripBooking.getDriver().getName()+
                    " From "+tripBooking.getPikUp()+" to "+tripBooking.getDropOff()+
                    " Please contact on this number "+tripBooking.getDriver().getMobileNo()
                    +"  This is your OTP "+otp+" and Don't share this OTP ";
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("noreply24april@gmail.com");
        simpleMailMessage.setTo(tripBooking.getCustomers().getEmailId());
        simpleMailMessage.setSubject("Cab Booked!!!");
        simpleMailMessage.setText(text);

        // send the email
        javaMailSender.send(simpleMailMessage);
    }

    public CustomerResponse cancelTrip(String emailId,Integer no) {

            Customers customers = customerRepository.findByEmailId(emailId);

            List<TripBooking> tripBookingList = customers.getTripBookings();
            String id = tripBookingList.get(no+1).getBookingId();
            TripBooking tripBooking = tripBookingRepository.findByID(id);
            int id1 = tripBooking.getId();
            TripBooking tripBooking1 = tripBookingRepository.findById(id1).get();
            tripBooking1.getDriver().getCab().setAvailable(true);
            tripBooking1.setTripStatus(TripStatus.CANCELED);

            tripBookingRepository.save(tripBooking1);
            sendMail2(tripBooking1);
            return CustomerTranform.CustomerToCustomerResponse(tripBooking1.getCustomers());
    }

    private void sendMail2(TripBooking tripBooking) {
        String text = "Dear "+tripBooking.getCustomers().getName()+" Your " +
                "cab has been Cancelled  successfully " +" Your amount will refund shortly in your " +
                "source account";
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("noreply24april@gmail.com");
        simpleMailMessage.setTo(tripBooking.getCustomers().getEmailId());
        simpleMailMessage.setSubject("Cab Cancelled!!!");
        simpleMailMessage.setText(text);

        // send the email
        javaMailSender.send(simpleMailMessage);
    }
}
