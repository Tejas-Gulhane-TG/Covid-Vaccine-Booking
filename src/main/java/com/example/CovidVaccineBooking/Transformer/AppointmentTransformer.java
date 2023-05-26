package com.example.CovidVaccineBooking.Transformer;

import com.example.CovidVaccineBooking.Dto.RequestDto.AppointmentRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.AppointmentResponseDto;
import com.example.CovidVaccineBooking.Model.Appointment;

public class AppointmentTransformer {

    public static Appointment AppointmentDtoToAppointMent(AppointmentRequestDto appointmentRequestDto){

        return Appointment.builder()
                .doesNo(appointmentRequestDto.getDoesNo())
                .vaccineType(appointmentRequestDto.getVaccineType())
                .build();
    }

    public static AppointmentResponseDto AppointmentToResponseDto(Appointment appointment){

        return AppointmentResponseDto.builder()
                .DateOfAppointment(appointment.getDateOfAppointment())
                .DoctorName(appointment.getDoctor().getName())
                .CenterName(appointment.getDoctor().getCenter().getName())
                .UserNo(appointment.getUser().getUserNo())
                .doesNo(appointment.getDoesNo())
                .UserName(appointment.getUser().getName())
                .vaccineType(appointment.getVaccineType())
                .build();
    }
}
