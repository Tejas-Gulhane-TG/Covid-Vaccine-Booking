package com.example.CovidVaccineBooking.Model;

import com.example.CovidVaccineBooking.Enum.VaccineType;
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
public class Does2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String DoesUID;

    @Enumerated(EnumType.STRING)
    VaccineType vaccineType;

    @CreationTimestamp
    Date dateOfDoes2;


    @OneToOne
    @JoinColumn(referencedColumnName = "userNo")
    User user;


}
