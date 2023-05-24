package com.example.CovidVaccineBooking.Service;

import com.example.CovidVaccineBooking.Dto.RequestDto.DoctorRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.DoctorResponseDto;

public interface DoctorService {
    DoctorResponseDto AddDoctor(DoctorRequestDto doctorRequestDto);

    DoctorResponseDto GetDoctorByNo(Integer no);

    void DeleteDoctorByNo(Integer no);
}
