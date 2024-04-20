package com.example.Get.Your.Ride.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Drivers")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer DriverId;

    String name;

    @Column(unique = true)
    String mobileNo;

    double rating;

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    @JsonIgnore
    Cab cab;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    List<TripBooking> tripBookings = new ArrayList<>();

}