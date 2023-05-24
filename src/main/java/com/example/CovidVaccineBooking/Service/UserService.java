package com.example.CovidVaccineBooking.Service;

import com.example.CovidVaccineBooking.Dto.RequestDto.UserRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.UserResponseDto;

public interface UserService {

    UserResponseDto AddUser(UserRequestDto userRequestDto);

    UserResponseDto GetUser(Integer no);

    void DeleteUserById(Integer no);
}
