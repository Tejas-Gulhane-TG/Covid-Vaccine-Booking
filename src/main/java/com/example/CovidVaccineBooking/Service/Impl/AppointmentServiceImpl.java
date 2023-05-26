package com.example.CovidVaccineBooking.Service.Impl;

import com.example.CovidVaccineBooking.Dto.RequestDto.AppointmentRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.AppointmentResponseDto;
import com.example.CovidVaccineBooking.Enum.DoesNo;
import com.example.CovidVaccineBooking.Exception.AlreadyTakenException;
import com.example.CovidVaccineBooking.Exception.DoctorNotFoundException;
import com.example.CovidVaccineBooking.Exception.NotEligibleException;
import com.example.CovidVaccineBooking.Exception.UserNotFoundException;
import com.example.CovidVaccineBooking.Model.*;
import com.example.CovidVaccineBooking.Repository.*;
import com.example.CovidVaccineBooking.Service.AppointmentService;
import com.example.CovidVaccineBooking.Transformer.AppointmentTransformer;
import com.example.CovidVaccineBooking.Uuid.RandomKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    Does1Repository does1Repository;
    @Autowired
    Does2Repository does2Repository;

    @Autowired
    JavaMailSender mailSender;


    @Override
    public AppointmentResponseDto BookAppointment(AppointmentRequestDto appointmentRequestDto) throws  NotEligibleException, UserNotFoundException, DoctorNotFoundException, AlreadyTakenException {

        User user = userRepository.findByUserNo(appointmentRequestDto.getUserNo());
        Doctor doctor = doctorRepository.findByDoctorNo(appointmentRequestDto.getDoctorNo());


        if(doctor == null){
            throw new DoctorNotFoundException("Doctor Not Found");
        }

        if(user == null){
            throw new UserNotFoundException("User Not Found");
        }

        Appointment appointment = AppointmentTransformer.AppointmentDtoToAppointMent(appointmentRequestDto);
        appointment.setAppointmentUid(RandomKey.UID());
        appointment.setUser(user);
        appointment.setDoctor(doctor);



        if(appointment.getDoesNo() == DoesNo.DOES_1 && user.getDoes_1_Taken()==true ){

                throw new AlreadyTakenException("You have already taken Does-1, So you are Not Eligible for Vaccination, Please book Appointment for DOES-2 ");
        }
        if(appointment.getDoesNo() == DoesNo.DOES_2 && user.getDoes_2_Taken()==true) {

            throw new AlreadyTakenException("You have already taken Does-2, So you are Not Eligible for Vaccination");

        }


        if(appointment.getDoesNo() == DoesNo.DOES_2 && user.getDoes_1_Taken() == false){
            throw new NotEligibleException("You are Not Eligible For DOES-2 please book Appointment for DOES-1 ");
        }

        if(appointment.getDoesNo() == DoesNo.DOES_1 ){
            user.setDoes_1_Taken(true);
            Does1 does1 = Does1.builder()
                    .DoesUID(Integer.toString(appointment.getAppointmentUid()))
                    .vaccineType(appointment.getVaccineType())
                    .user(user)
                    .build();

            does1Repository.save(does1);
        }
        if(appointment.getDoesNo() == DoesNo.DOES_2){
            user.setDoes_2_Taken(true);
            Does2 does2 = Does2.builder()
                    .DoesUID(Integer.toString(appointment.getAppointmentUid()))
                    .vaccineType(appointment.getVaccineType())
                    .user(user)
                    .build();
            does2Repository.save(does2);
        }

        userRepository.save(user);
        doctorRepository.save(doctor);
        appointmentRepository.save(appointment);

        String text = " Congrats!! " + user.getName() + " Your "+ appointment.getDoesNo() +" Vaccine "+ appointment.getVaccineType()+ " has been booked!!";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("covid19vaccinebooking@gmail.com");
        message.setTo(user.getEmailId());
        message.setSubject(" Appointment Booked !!!");
        message.setText(text);
        mailSender.send(message);

        return AppointmentTransformer.AppointmentToResponseDto(appointment);

    }
}
