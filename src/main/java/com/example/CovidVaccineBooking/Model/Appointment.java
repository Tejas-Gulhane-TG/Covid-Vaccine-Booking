package com.example.CovidVaccineBooking.Model;

import com.example.CovidVaccineBooking.Enum.Does;
import com.example.CovidVaccineBooking.UUIDNO.AppointmentNo;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false, unique = true)
    String appointmentNo= Integer.toString(AppointmentNo.AppointmentNo());

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Does does;



}
