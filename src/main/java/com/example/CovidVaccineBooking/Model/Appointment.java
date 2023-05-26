package com.example.CovidVaccineBooking.Model;

import com.example.CovidVaccineBooking.Enum.DoesNo;
import com.example.CovidVaccineBooking.Enum.VaccineType;
import com.example.CovidVaccineBooking.Uuid.RandomKey;
import com.example.CovidVaccineBooking.Uuid.RandomNo;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.UUID;

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

    @Column(unique = true)
    int appointmentUid;

    @Enumerated(EnumType.STRING)
    DoesNo doesNo;

    @CreationTimestamp
    Date dateOfAppointment;

    @Enumerated(EnumType.STRING)
    VaccineType vaccineType;

    @ManyToOne
    @JoinColumn(referencedColumnName = "userNo")
    User user;

    @ManyToOne
    @JoinColumn(referencedColumnName = "doctorNo")
    Doctor doctor;


}
