package com.example.Get.Your.Ride.Models;


import com.example.Get.Your.Ride.Enums.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customers {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer customerId;

    @Column(unique = true)
    String mobileNo;

    @Column(unique = true)
    String emailId;

    String name;

    @Enumerated(value = EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "customers")
    List<TripBooking> tripBookings = new ArrayList<>();





}
