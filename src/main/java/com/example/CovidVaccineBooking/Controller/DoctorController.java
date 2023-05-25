package com.example.CovidVaccineBooking.Controller;

import com.example.CovidVaccineBooking.Dto.RequestDto.DoctorRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.DoctorResponseDto;
import com.example.CovidVaccineBooking.Exception.CenterNotPresentException;
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

        try {
            DoctorResponseDto doctorResponseDto = doctorService.AddDoctor(doctorRequestDto);
            return new ResponseEntity(doctorResponseDto,HttpStatus.CREATED);
        }
        catch (CenterNotPresentException e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/Get-Doctor-By-No/{no}")
    public ResponseEntity GetDoctorByNo(@PathVariable Integer no){
        DoctorResponseDto doctorResponseDto = doctorService.GetDoctorByNo(no);
        return new ResponseEntity(doctorResponseDto, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-doctor-by-no/{no}")
    public ResponseEntity DeleteDoctorByNo(@PathVariable Integer no){
        doctorService.DeleteDoctorByNo(no);
        return new ResponseEntity("Doctor Delete Successfully ", HttpStatus.OK);
    }

}
