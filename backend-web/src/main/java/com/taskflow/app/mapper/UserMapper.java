package com.taskflow.app.mapper;

import com.taskflow.app.dto.UserDTO;
import com.taskflow.app.entity.User;

public class UserMapper {
    public static UserDTO mapToUserDto(User _user){
        return new UserDTO(
                _user.getId(),
                _user.getName(),
                _user.getPassword(),
                _user.getEmail()

        );
    }
    public static User mapToUser(UserDTO _userDto){
        return new User(
                _userDto.getId(),
                _userDto.getName(),
                _userDto.getPassword(),
                _userDto.getEmail()
        );
    }
}
