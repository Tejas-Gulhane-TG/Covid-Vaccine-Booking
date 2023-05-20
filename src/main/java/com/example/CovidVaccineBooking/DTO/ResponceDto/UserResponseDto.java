package com.example.CovidVaccineBooking.DTO.ResponceDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {
    int UserId;
    String Name;
    int Age;
    String MobileNo;
    String EmailId;

}
