package com.example.CovidVaccineBooking.Dto.ResponseDto;

import com.example.CovidVaccineBooking.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponseDto {

    int UserNo;
    String Name;
    int Age;

    long MobileNo;

    String EmailId;

    Gender gender;
}
