package com.example.CovidVaccineBooking.DTO.RequestDto;

import com.example.CovidVaccineBooking.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {

    String name;
    int age;
    String emailId;
    String mobileNo;

}
