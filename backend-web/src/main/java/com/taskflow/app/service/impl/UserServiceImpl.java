package com.taskflow.app.service.impl;

import com.taskflow.app.dto.UserDTO;
import com.taskflow.app.entity.User;
import com.taskflow.app.mapper.UserMapper;
import com.taskflow.app.repository.UserRepository;
import com.taskflow.app.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository _userRepository;
    @Override
    public UserDTO createUser(UserDTO _userDto) {
        User _user = UserMapper.mapToUser(_userDto);
        User savedUser = _userRepository.save(_user);
        return UserMapper.mapToUserDto(savedUser);
    }
    @Override
    public List<UserDTO> getAllUser(){
        List<User> users = _userRepository.findAll();
        return users.stream().map(UserMapper::mapToUserDto).toList();
    }
}
