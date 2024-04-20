package com.example.Get.Your.Ride.Models;


import com.example.Get.Your.Ride.Enums.CarType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name ="cabs")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer cabId;

    @Column(unique = true,nullable = false)
    String cabNo;

    String companyName;

    @Enumerated(value =  EnumType.STRING)
    CarType carType;

    Integer noOfSeats;

    boolean isAvailable;

    Integer  farePerks;

    @OneToOne
    @JoinColumn(name = "DriverId")
    Driver driver;


}
