package com.example.CovidVaccineBooking.Dto.RequestDto;

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
public class DoctorRequestDto {

    String name;

    int age;

    Gender gender;

    long mobileNo;

    String emailId;
}
