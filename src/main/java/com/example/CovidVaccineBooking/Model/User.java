package com.example.CovidVaccineBooking.Model;

import com.example.CovidVaccineBooking.Enum.Gender;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String UserNo = Integer.toString(UUID.Uid());

    String name;

    @Column(unique = true, nullable = false)
    String mobileNo;

    @Column(unique = true, nullable = false)
    String emailId;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;
}
