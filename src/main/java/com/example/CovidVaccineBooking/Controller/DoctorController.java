package com.example.CovidVaccineBooking.Controller;

import com.example.CovidVaccineBooking.Dto.RequestDto.DoctorRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.DoctorResponseDto;
import com.example.CovidVaccineBooking.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {


    @Autowired
    DoctorService doctorService;


    @PostMapping("/add")
    public ResponseEntity AddDoctor(@RequestBody DoctorRequestDto doctorRequestDto){
        DoctorResponseDto doctorResponseDto = doctorService.AddDoctor(doctorRequestDto);
        return new ResponseEntity(doctorResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/Get-Doctor-By-No/{no}")
    public ResponseEntity GetDoctorByNo(@PathVariable Integer no){
        DoctorResponseDto doctorResponseDto = doctorService.GetDoctorByNo(no);
        return new ResponseEntity(doctorResponseDto, HttpStatus.FOUND);
    }

}