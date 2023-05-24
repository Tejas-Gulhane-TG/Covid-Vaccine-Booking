package com.example.CovidVaccineBooking.Service.Impl;

import com.example.CovidVaccineBooking.Dto.RequestDto.DoctorRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.DoctorResponseDto;
import com.example.CovidVaccineBooking.Model.Doctor;
import com.example.CovidVaccineBooking.Repository.DoctorRepository;
import com.example.CovidVaccineBooking.Service.DoctorService;
import com.example.CovidVaccineBooking.Transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    @Override
    public DoctorResponseDto AddDoctor(DoctorRequestDto doctorRequestDto) {

        Doctor doctor = DoctorTransformer.DoctorRequest(doctorRequestDto);

        doctorRepository.save(doctor);

        DoctorResponseDto doctorResponseDto = DoctorTransformer.DoctorResponse(doctor);

        return doctorResponseDto;
    }

    @Override
    public DoctorResponseDto GetDoctorByNo(Integer no) {

        Doctor doctor = doctorRepository.findByDoctorNo(no);

        DoctorResponseDto doctorResponseDto = DoctorTransformer.DoctorResponse(doctor);

        return doctorResponseDto;
    }

    @Override
    public void DeleteDoctorByNo(Integer no) {
        Doctor doctor =doctorRepository.findByDoctorNo(no);
        doctorRepository.deleteById(doctor.getId());
    }
}
