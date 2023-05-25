package com.example.CovidVaccineBooking.Dto.RequestDto;

import com.example.CovidVaccineBooking.Enum.CenterType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CenterRequestDto {
    String name;
    String address;
    CenterType centerType;
}
