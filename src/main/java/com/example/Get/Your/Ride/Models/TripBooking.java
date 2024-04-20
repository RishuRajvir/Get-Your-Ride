package com.example.Get.Your.Ride.Models;

import com.example.Get.Your.Ride.Enums.TripStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "TripBooking")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TripBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String bookingId;

    String pikUp;

    String dropOff;

    double tripDistance;

    double totalFare;

    @Enumerated(value = EnumType.STRING)
    TripStatus TripStatus;

    @CreationTimestamp
    Date bookAt;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Customers customers;


    @ManyToOne
    @JoinColumn
    @JsonIgnore
    Driver driver;

}
