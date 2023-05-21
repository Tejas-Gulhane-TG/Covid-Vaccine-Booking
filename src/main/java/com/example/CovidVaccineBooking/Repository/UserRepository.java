package com.example.CovidVaccineBooking.Repository;

import com.example.CovidVaccineBooking.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserNo(Integer UserNo);
}
