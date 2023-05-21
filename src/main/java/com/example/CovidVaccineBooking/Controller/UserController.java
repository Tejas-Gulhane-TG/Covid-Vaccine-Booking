package com.example.CovidVaccineBooking.Controller;

import com.example.CovidVaccineBooking.Dto.RequestDto.UserRequestDto;
import com.example.CovidVaccineBooking.Dto.ResponseDto.UserResponseDto;
import com.example.CovidVaccineBooking.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity AddUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = userService.AddUser(userRequestDto);
        return new ResponseEntity(userResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get-user-no/{no}")
    public ResponseEntity GetUser(@PathVariable Integer no){
        UserResponseDto userResponseDto = userService.GetUser(no);
        return new ResponseEntity(userResponseDto, HttpStatus.FOUND);
    }

}
