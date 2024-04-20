package com.example.Get.Your.Ride.DtoResponse;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerResponse {
        String name;
        String mobileNo;
        String email;
}
