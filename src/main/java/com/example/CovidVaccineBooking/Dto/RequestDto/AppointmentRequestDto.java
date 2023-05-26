package com.example.CovidVaccineBooking.Dto.RequestDto;

import com.example.CovidVaccineBooking.Enum.DoesNo;
import com.example.CovidVaccineBooking.Enum.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentRequestDto {

    DoesNo doesNo;

    int userNo;

    int doctorNo;

    VaccineType vaccineType;
}
