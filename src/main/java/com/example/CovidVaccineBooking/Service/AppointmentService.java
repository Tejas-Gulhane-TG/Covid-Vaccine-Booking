package com.example.CovidVaccineBooking.Service;

import com.example.CovidVaccineBooking.Dto.RequestDto.AppointmentRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.AppointmentResponseDto;
import com.example.CovidVaccineBooking.Exception.*;

public interface AppointmentService {
    AppointmentResponseDto BookAppointment(AppointmentRequestDto appointmentRequestDto)
            throws NotEligibleException, UserNotFoundException, DoctorNotFoundException, AlreadyTakenException;
}
