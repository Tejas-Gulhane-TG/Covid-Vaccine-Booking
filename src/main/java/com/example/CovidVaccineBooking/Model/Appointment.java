package com.example.CovidVaccineBooking.Model;

import com.example.CovidVaccineBooking.Enum.DoesNo;
import com.example.CovidVaccineBooking.Uuid.RandomNo;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    Integer appointmentUid = RandomNo.uid();

    @Enumerated(EnumType.STRING)
    DoesNo doesNo;

    @CreationTimestamp
    Date dateOfAppointment;


    @ManyToOne
    @JoinColumn(referencedColumnName = "userNo")
    User user;

    @ManyToOne
    @JoinColumn(referencedColumnName = "doctorNo")
    Doctor doctor;


}
