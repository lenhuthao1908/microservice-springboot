package com.microservices.service;

import com.microservices.dto.request.CreateUserDto;
import com.microservices.dto.request.UpdateUserDto;
import com.microservices.dto.response.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> findAllUser();
    UserDto createUser(CreateUserDto createUserDto);
    UserDto updateUser(UpdateUserDto updateUserDto);
    UserDto findUserById(Long id);
    UserDto getUserInfo();
    void deleteUser(Long id);
}
