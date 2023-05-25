package com.example.CovidVaccineBooking.Controller;

import com.example.CovidVaccineBooking.Dto.RequestDto.CenterRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.CenterResponseDto;
import com.example.CovidVaccineBooking.Model.Doctor;
import com.example.CovidVaccineBooking.Service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/center")
public class CenterController {

    @Autowired
    CenterService centerService;
    @PostMapping("/add-center")
    public ResponseEntity AddCenter(@RequestBody CenterRequestDto centerRequestDto){
        CenterResponseDto centerResponseDto = centerService.AddCenter(centerRequestDto);
        return new ResponseEntity(centerResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get-center-By-No/{no}")
    public ResponseEntity GetCenterByNo(@PathVariable Integer no){
        CenterResponseDto centerResponseDto = centerService.GetCenterByNo(no);
        return new ResponseEntity(centerResponseDto, HttpStatus.FOUND);
    }

    @GetMapping("/get-all-doctors-from-center/{no}")
    public ResponseEntity GetDoctorsList(@PathVariable Integer no){

        List<String> doctorList = centerService.GetDoctorsList(no);
        return  new ResponseEntity(doctorList, HttpStatus.FOUND);
    }
}
