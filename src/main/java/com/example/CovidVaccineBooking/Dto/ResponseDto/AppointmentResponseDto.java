package com.example.CovidVaccineBooking.Dto.ResponseDto;

import com.example.CovidVaccineBooking.Enum.DoesNo;
import com.example.CovidVaccineBooking.Enum.VaccineType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class AppointmentResponseDto {

    String UserName;
    int UserNo;
    String DoctorName;
    String CenterName;
    Date DateOfAppointment;
    DoesNo doesNo;
    VaccineType vaccineType;
}
