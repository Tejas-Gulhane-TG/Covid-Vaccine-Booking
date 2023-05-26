package com.example.CovidVaccineBooking.Controller;

import com.example.CovidVaccineBooking.Dto.RequestDto.AppointmentRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.AppointmentResponseDto;
import com.example.CovidVaccineBooking.Exception.*;
import com.example.CovidVaccineBooking.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    @PostMapping("/book")
    public ResponseEntity BookAppointment(@RequestBody AppointmentRequestDto appointmentRequestDto){
        try {
            AppointmentResponseDto appointmentResponseDto = appointmentService.BookAppointment(appointmentRequestDto);
            return  new ResponseEntity(appointmentResponseDto, HttpStatus.ACCEPTED);
        }
        catch (UserNotFoundException g){
            return new ResponseEntity(g.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (NotEligibleException g){
            return new ResponseEntity(g.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (DoctorNotFoundException g){
            return new ResponseEntity(g.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (AlreadyTakenException g){
            return new ResponseEntity(g.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
