package com.example.CovidVaccineBooking.Transformer;

import com.example.CovidVaccineBooking.Dto.RequestDto.UserRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.UserResponseDto;
import com.example.CovidVaccineBooking.Model.User;

public class UserTransformer {

    public static User RequestDto(UserRequestDto userRequestDto){

        User user= new User();

        user.setName(userRequestDto.getName());
        user.setAge(userRequestDto.getAge());
        user.setEmailId(userRequestDto.getEmailId());
        user.setGender(userRequestDto.getGender());
        user.setMobileNo(userRequestDto.getMobileNo());

        return user;
    }

    public static UserResponseDto ResponseDto(User user){

        UserResponseDto userResponseDto= new UserResponseDto();

        userResponseDto.setName(user.getName());
        userResponseDto.setUserNo(user.getUserNo());
        userResponseDto.setAge(user.getAge());
        userResponseDto.setGender(user.getGender());
        userResponseDto.setEmailId(user.getEmailId());
        userResponseDto.setMobileNo(user.getMobileNo());

        return userResponseDto;
    }
}
