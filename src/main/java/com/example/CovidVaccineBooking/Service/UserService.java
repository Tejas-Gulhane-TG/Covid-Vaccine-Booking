package com.example.CovidVaccineBooking.Service;

import com.example.CovidVaccineBooking.DTO.RequestDto.UserRequestDto;
import com.example.CovidVaccineBooking.DTO.ResponceDto.UserResponseDto;

public interface UserService {

    UserResponseDto AddUser(UserRequestDto userRequestDto);

    UserResponseDto GetUserByUserId(String mobileNo);
}
