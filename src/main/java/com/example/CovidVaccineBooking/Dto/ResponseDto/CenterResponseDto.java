package com.example.CovidVaccineBooking.Dto.ResponseDto;

import com.example.CovidVaccineBooking.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CenterResponseDto {
    int CenterNo;
    String Name;
    String Address;
    CenterType centerType;
}
