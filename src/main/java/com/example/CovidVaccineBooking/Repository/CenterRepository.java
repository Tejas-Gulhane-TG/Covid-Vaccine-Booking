package com.example.CovidVaccineBooking.Repository;

import com.example.CovidVaccineBooking.Model.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<Center, Integer> {
    Center findByCenterNo(Integer centerNo);
}
