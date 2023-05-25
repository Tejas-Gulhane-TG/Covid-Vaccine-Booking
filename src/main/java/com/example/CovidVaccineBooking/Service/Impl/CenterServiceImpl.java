package com.example.CovidVaccineBooking.Service.Impl;

import com.example.CovidVaccineBooking.Dto.RequestDto.CenterRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.CenterResponseDto;
import com.example.CovidVaccineBooking.Model.Center;
import com.example.CovidVaccineBooking.Model.Doctor;
import com.example.CovidVaccineBooking.Repository.CenterRepository;
import com.example.CovidVaccineBooking.Repository.DoctorRepository;
import com.example.CovidVaccineBooking.Service.CenterService;
import com.example.CovidVaccineBooking.Transformer.CenterTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CenterServiceImpl implements CenterService {

    @Autowired
    CenterRepository centerRepository;

    @Override
    public CenterResponseDto GetCenterByNo(Integer no) {
        Center center = centerRepository.findByCenterNo(no);
        CenterResponseDto centerResponseDto = CenterTransformer.CenterToResponseDto(center);
        return centerResponseDto;
    }

    @Override
    public CenterResponseDto AddCenter(CenterRequestDto centerRequestDto) {

        Center center = CenterTransformer.CenterRequestDtoToDoctor(centerRequestDto);

        centerRepository.save(center);

        CenterResponseDto centerResponseDto = CenterTransformer.CenterToResponseDto(center);

        return centerResponseDto;
    }

    @Override
    public List<String> GetDoctorsList(Integer no) {

        Center center = centerRepository.findByCenterNo(no);

        List<Doctor> doctors = center.getDoctors();
        List<String> names = new ArrayList<>();

        for(Doctor doctor: doctors){
            names.add(doctor.getName());
        }
        return names;
    }

}
