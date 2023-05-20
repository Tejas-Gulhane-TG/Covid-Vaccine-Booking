package com.example.CovidVaccineBooking.Model;

import com.example.CovidVaccineBooking.Enum.VaccineName;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Does2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true, nullable = false)
    int appointmentNo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    VaccineName vaccineName;

    @CreationTimestamp
    Date dateOfDoes2;
}
