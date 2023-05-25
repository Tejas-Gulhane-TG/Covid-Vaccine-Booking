package com.example.CovidVaccineBooking.Model;

import com.example.CovidVaccineBooking.Enum.Gender;
import com.example.CovidVaccineBooking.Uuid.RandomNo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(unique = true)
    int doctorNo= RandomNo.uid();

    @Column(unique = true)
    long mobileNo;

    @Column(unique = true)
    String emailId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "centerNo")
    Center center;
}
