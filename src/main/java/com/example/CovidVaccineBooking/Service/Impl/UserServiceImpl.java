package com.example.CovidVaccineBooking.Service.Impl;

import com.example.CovidVaccineBooking.Dto.RequestDto.UserRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.UserResponseDto;
import com.example.CovidVaccineBooking.Model.User;
import com.example.CovidVaccineBooking.Repository.UserRepository;
import com.example.CovidVaccineBooking.Service.UserService;
import com.example.CovidVaccineBooking.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserResponseDto AddUser(UserRequestDto userRequestDto) {

        User user = UserTransformer.RequestDto(userRequestDto);
        userRepository.save(user);
        UserResponseDto userResponseDto = UserTransformer.ResponseDto(user);

        if(user.getDoes_1_Taken() ==false){
            userResponseDto.setDoes_1_is_Taken("No");
        }
        if(user.getDoes_2_Taken() ==false){
            userResponseDto.setDoes_2_is_Taken("No");
        }

        return userResponseDto;
    }

    @Override
    public UserResponseDto GetUserById(Integer no) {
        User user = userRepository.findByUserNo(no);
        UserResponseDto userResponseDto = UserTransformer.ResponseDto(user);
        return userResponseDto;
    }

    @Override
    public void DeleteUserById(Integer no) {
        User user = userRepository.findByUserNo(no);
        userRepository.deleteById(user.getId());
        return ;
    }
}
