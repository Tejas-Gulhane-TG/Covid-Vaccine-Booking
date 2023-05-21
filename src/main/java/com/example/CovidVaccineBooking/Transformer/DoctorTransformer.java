package com.example.CovidVaccineBooking.Transformer;

import com.example.CovidVaccineBooking.Dto.RequestDto.DoctorRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.DoctorResponseDto;
import com.example.CovidVaccineBooking.Model.Doctor;

import javax.print.Doc;

public class DoctorTransformer {

    public static Doctor DoctorRequest(DoctorRequestDto doctorRequestDto){

        Doctor doctor = new Doctor();

        doctor.setName(doctorRequestDto.getName());
        doctor.setAge(doctorRequestDto.getAge());
        doctor.setGender(doctorRequestDto.getGender());
        doctor.setEmailId(doctorRequestDto.getEmailId());
        doctor.setMobileNo(doctorRequestDto.getMobileNo());

        return doctor;
    }

    public static DoctorResponseDto DoctorResponse(Doctor doctor){

        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();

        doctorResponseDto.setDoctorNo(doctor.getDoctorNo());
        doctorResponseDto.setAge(doctor.getAge());
        doctorResponseDto.setName(doctor.getName());
        doctorResponseDto.setGender(doctor.getGender());
        doctorResponseDto.setEmailId(doctor.getEmailId());
        doctorResponseDto.setMobileNo(doctor.getMobileNo());

        return doctorResponseDto;

    }

}
