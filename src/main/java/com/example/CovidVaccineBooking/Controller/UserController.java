package com.example.CovidVaccineBooking.Controller;

import com.example.CovidVaccineBooking.DTO.RequestDto.UserRequestDto;
import com.example.CovidVaccineBooking.DTO.ResponceDto.UserResponseDto;
import com.example.CovidVaccineBooking.Model.User;
import com.example.CovidVaccineBooking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired UserService userService;
    @PostMapping("/add")
    public ResponseEntity AddUser(@RequestBody UserRequestDto userRequestDto){

        UserResponseDto userResponseDto = userService.AddUser(userRequestDto);
        return new ResponseEntity(userResponseDto, HttpStatus.CREATED);

    }

    @GetMapping("/get-by-userId/{userId}")
    public ResponseEntity GetUserByUserId(@PathVariable String userId){
        UserResponseDto userResponseDto = userService.GetUserByUserId(userId);
        return new ResponseEntity(userResponseDto, HttpStatus.FOUND);
    }
}
