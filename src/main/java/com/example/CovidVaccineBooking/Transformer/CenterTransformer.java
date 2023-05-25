package com.example.CovidVaccineBooking.Transformer;

import com.example.CovidVaccineBooking.Dto.RequestDto.CenterRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.CenterResponseDto;
import com.example.CovidVaccineBooking.Model.Center;
import com.example.CovidVaccineBooking.Uuid.RandomKey;

public class CenterTransformer {

    public static Center CenterRequestDtoToDoctor(CenterRequestDto centerRequestDto){
        return Center.builder()
                .centerType(centerRequestDto.getCenterType())
                .name(centerRequestDto.getName())
                .address(centerRequestDto.getAddress())
                .centerNo(RandomKey.UID())
                .build();
    }

    public static CenterResponseDto CenterToResponseDto(Center center){
        return CenterResponseDto.builder()
                .centerType(center.getCenterType())
                .Address(center.getAddress())
                .CenterNo(center.getCenterNo())
                .Name(center.getName())
                .build();
    }
}
