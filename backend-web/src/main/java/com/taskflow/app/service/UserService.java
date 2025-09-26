package com.taskflow.app.service;

import com.taskflow.app.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO _userDto);
    List<UserDTO> getAllUser();
}


