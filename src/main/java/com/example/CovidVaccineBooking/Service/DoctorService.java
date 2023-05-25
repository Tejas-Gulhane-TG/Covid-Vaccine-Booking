package com.example.CovidVaccineBooking.Service;

import com.example.CovidVaccineBooking.Dto.RequestDto.DoctorRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.DoctorResponseDto;
import com.example.CovidVaccineBooking.Exception.CenterNotPresentException;

public interface DoctorService {
    DoctorResponseDto AddDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException;

    DoctorResponseDto GetDoctorByNo(Integer no);

    void DeleteDoctorByNo(Integer no);
}
