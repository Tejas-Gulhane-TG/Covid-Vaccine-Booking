package com.example.CovidVaccineBooking.Model;

import com.example.CovidVaccineBooking.Enum.Gender;
import com.example.CovidVaccineBooking.Uuid.RandomNo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(unique = true)
    int userNo= RandomNo.uid();

    @Column(unique = true)
    long mobileNo;

    @Column(unique = true, nullable = false)
    String emailId;

    Boolean does_1_Taken;
    Boolean does_2_Taken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Appointment> appointments = new ArrayList<>();

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Does1 does1;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    Does2 does2;

}
