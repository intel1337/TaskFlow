package com.taskflow.app.controller;

import com.taskflow.app.dto.UserDTO;
import com.taskflow.app.entity.User;
import com.taskflow.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService _userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO _userDto){
           UserDTO savedUser =  _userService.createUser(_userDto);
           return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }
    @GetMapping("/get-all")
    public ResponseEntity<User> getAllUser(){
        User allUsers = (User) _userService.getAllUser();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}

