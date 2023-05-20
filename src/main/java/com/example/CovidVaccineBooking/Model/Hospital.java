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
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true, nullable = false)
    String hospitalId= Integer.toString(UUID.Uid());

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String location;
}
