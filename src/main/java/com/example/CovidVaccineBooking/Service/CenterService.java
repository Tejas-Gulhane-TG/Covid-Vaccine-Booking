package com.example.CovidVaccineBooking.Service;

import com.example.CovidVaccineBooking.Dto.RequestDto.CenterRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.CenterResponseDto;
import com.example.CovidVaccineBooking.Model.Doctor;

import java.util.List;

public interface CenterService {
    CenterResponseDto GetCenterByNo(Integer no);

    CenterResponseDto AddCenter(CenterRequestDto centerRequestDto);

    List<String> GetDoctorsList(Integer no);
}
