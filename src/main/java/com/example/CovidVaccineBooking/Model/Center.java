package com.example.CovidVaccineBooking.Model;

import com.example.CovidVaccineBooking.Enum.CenterType;
import com.example.CovidVaccineBooking.Uuid.RandomKey;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Center {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true)
    int centerNo= RandomKey.UID();

    String name;

    String address;

    @Enumerated(EnumType.STRING)
    CenterType centerType;

    @OneToMany (mappedBy = "center", cascade = CascadeType.ALL)
    List<Doctor> doctors = new ArrayList<>();

}
