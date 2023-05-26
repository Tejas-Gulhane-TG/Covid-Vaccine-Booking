package com.example.CovidVaccineBooking.Service.Impl;

import com.example.CovidVaccineBooking.Dto.RequestDto.DoctorRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.DoctorResponseDto;
import com.example.CovidVaccineBooking.Exception.CenterNotPresentException;
import com.example.CovidVaccineBooking.Model.Center;
import com.example.CovidVaccineBooking.Model.Doctor;
import com.example.CovidVaccineBooking.Model.User;
import com.example.CovidVaccineBooking.Repository.CenterRepository;
import com.example.CovidVaccineBooking.Repository.DoctorRepository;
import com.example.CovidVaccineBooking.Repository.UserRepository;
import com.example.CovidVaccineBooking.Service.DoctorService;
import com.example.CovidVaccineBooking.Transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    CenterRepository centerRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public DoctorResponseDto AddDoctor(DoctorRequestDto doctorRequestDto) throws CenterNotPresentException  {

        Center center = centerRepository.findByCenterNo(doctorRequestDto.getCenterNo());

        if(center == null){
            throw new CenterNotPresentException("Center not found");
        }

        Doctor doctor = DoctorTransformer.DoctorRequest(doctorRequestDto);

        doctor.setCenter(center);
        doctorRepository.save(doctor);
        center.getDoctors().add(doctor);

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
