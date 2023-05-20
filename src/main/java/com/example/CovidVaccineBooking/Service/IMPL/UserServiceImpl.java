package com.example.CovidVaccineBooking.Service.IMPL;

import com.example.CovidVaccineBooking.DTO.RequestDto.UserRequestDto;
import com.example.CovidVaccineBooking.DTO.ResponceDto.UserResponseDto;
import com.example.CovidVaccineBooking.Model.User;
import com.example.CovidVaccineBooking.Repository.UserRepository;
import com.example.CovidVaccineBooking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserResponseDto AddUser(UserRequestDto userRequestDto) {

        User user = new User();

//        Request DTO to Entity

        user.setAge(userRequestDto.getAge());
        user.setEmailId(userRequestDto.getEmailId());
        user.setMobileNo(userRequestDto.getMobileNo());
        user.setName(userRequestDto.getName());


//        Save User Into Database
        User SavedUser = userRepository.save(user);

//        Entity to ResponseDto

        return UserResponseDto.builder()
                .Age(SavedUser.getAge())
                .UserId(Integer.valueOf(SavedUser.getUserNo()))
                .Name(SavedUser.getName())
                .EmailId(SavedUser.getEmailId())
                .MobileNo(SavedUser.getMobileNo())
                .build();
    }

    @Override
    public UserResponseDto GetUserByUserId(String userId) {

        User SavedUser = userRepository.findByUserNo(userId);

        return UserResponseDto.builder()
                .Age(SavedUser.getAge())
                .UserId(Integer.valueOf(SavedUser.getUserNo()))
                .Name(SavedUser.getName())
                .EmailId(SavedUser.getEmailId())
                .MobileNo(SavedUser.getMobileNo())
                .build();
    }


}
