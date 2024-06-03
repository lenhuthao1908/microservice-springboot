package com.microserives.rest;

import com.microserives.dto.config.ApiResponse;
import com.microserives.dto.request.CreateUserDto;
import com.microserives.dto.request.UpdateUserDto;

public interface IApiUserRest {
    ApiResponse findAllUser();

    ApiResponse createUser(CreateUserDto createUserDto);

    ApiResponse updateUser(Long id, UpdateUserDto updateUserDto);

    ApiResponse findUserById(Long id);

    ApiResponse getUserInfo();

    ApiResponse deleteUser(Long id);
}
