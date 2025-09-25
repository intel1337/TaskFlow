package com.taskflow.app.controller;

import com.taskflow.app.dto.UserDTO;
import com.taskflow.app.entity.User;
import com.taskflow.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService _userService;

    //add employee
    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO _userDto){
           UserDTO savedUser =  _userService.createUser(_userDto);
           return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }
}
