package com.microserives.service;

import com.microserives.dto.request.CreateUserDto;
import com.microserives.dto.request.UpdateUserDto;
import com.microserives.dto.response.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> findAllUser();
    UserDto createUser(CreateUserDto createUserDto);
    UserDto updateUser(UpdateUserDto updateUserDto);
    UserDto findUserById(Long id);
    void deleteUser(Long id);
}
