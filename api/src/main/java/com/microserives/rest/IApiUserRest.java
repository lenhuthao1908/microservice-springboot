package com.microserives.rest;

import com.microserives.common.SwaggerConstant;
import com.microserives.dto.config.ApiResponse;
import com.microserives.dto.request.CreateUserDto;
import com.microserives.dto.request.UpdateUserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = SwaggerConstant.TAG_USER_API)
public interface IApiUserRest {
    @Operation(summary = SwaggerConstant.OPERATION_GET_LIST_API + SwaggerConstant.NAME_USER)
    ApiResponse findAllUser();

    @Operation(summary = SwaggerConstant.OPERATION_SAVE_API + SwaggerConstant.NAME_USER)
    ApiResponse createUser(CreateUserDto createUserDto);

    @Operation(summary = SwaggerConstant.OPERATION_UPDATE_API + SwaggerConstant.NAME_USER)
    ApiResponse updateUser(Long id, UpdateUserDto updateUserDto);

    @Operation(summary = SwaggerConstant.OPERATION_GET_API + SwaggerConstant.NAME_USER)
    ApiResponse findUserById(Long id);

    @Operation(summary = SwaggerConstant.OPERATION_GET_INFO_API + SwaggerConstant.NAME_USER)
    ApiResponse getUserInfo();

    @Operation(summary = SwaggerConstant.OPERATION_DELETE_API + SwaggerConstant.NAME_USER)
    ApiResponse deleteUser(Long id);
}
