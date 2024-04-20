package com.example.Get.Your.Ride.Service;


import com.example.Get.Your.Ride.DtoResquest.CustomerRequests;
import com.example.Get.Your.Ride.DtoResponse.CustomerResponse;
import com.example.Get.Your.Ride.Models.Customers;
import com.example.Get.Your.Ride.Repository.CustomerRepository;
import com.example.Get.Your.Ride.Tranform.CustomerTranform;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {


            private  final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository, JavaMailSender javaMailSender) {
        this.customerRepository = customerRepository;
        this.javaMailSender = javaMailSender;
    }

    public final JavaMailSender javaMailSender;

        public CustomerResponse addCustomer(CustomerRequests customerRequest){

           // We Build Object from  DTO requests
           Customers customers = CustomerTranform.CustomerRequestToCustomer(customerRequest);

            Customers Savedcustomers = customerRepository.save(customers);

            sendmail(Savedcustomers);
            // WE Build Response Entity from Saved Customers OF Repository

           CustomerResponse customerResponse = CustomerResponse.builder()
                   .name(Savedcustomers.getName())
                   .MobileNo(Savedcustomers.getMobileNo()).build();

            return customerResponse;
        }

    private void sendmail(Customers savedcustomers) {

                String text = " Thank you " + savedcustomers.getName()+" And Your Registered Mobile No is "+savedcustomers.getMobileNo()+
                        " To be the part of Our Family\n" +
                        " Wish You very well for Your Ride  " +
                        " Try this coupon for new Registrations TRYNEW40 for instant discount on " +
                        " booking cabs ";
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("noreply24april@gmail.com");
        simpleMailMessage.setTo(savedcustomers.getEmailId());
        simpleMailMessage.setText(text);
        simpleMailMessage.setSubject("Registration Successful");


        javaMailSender.send(simpleMailMessage);


    }

    public List<CustomerResponse> findCustomers(String gender) {
                List<Customers>  customers = customerRepository.findByGender(gender);
            List<CustomerResponse> customerResponses = new ArrayList<>();
            for(Customers customers1 : customers){
                    customerResponses.add(CustomerTranform.CustomerToCustomerResponse(customers1));
            }
            return customerResponses;
    }
}

