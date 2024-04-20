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
    Integer CabId;

    @Column(unique = true,nullable = false)
    String CabNo;

    String CompanyName;

    @Enumerated(value =  EnumType.STRING)
    CarType carType;

    Integer NoOfSeats;

    boolean isAvailable;

    Integer  FarePerks;

    @OneToOne
    @JoinColumn(name = "DriverId")
    Driver driver;


}
