package com.example.CovidVaccineBooking.Model;

import com.example.CovidVaccineBooking.UUIDNO.UUID;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false, unique = true)
    String doctorId= Integer.toString(UUID.Uid());

    String name;

    String mobileNo;

    String degree;
}
