package com.microservices.rest;

import com.microservices.common.SwaggerConstant;
import com.microservices.dto.config.ApiResponse;
import com.microservices.dto.request.CreateAccountDto;
import com.microservices.dto.request.UpdateAccountDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = SwaggerConstant.TAG_USER_API)
public interface IApiUserRest {
    @Operation(summary = SwaggerConstant.OPERATION_GET_LIST_API + SwaggerConstant.NAME_USER)
    ApiResponse findAllUser();

    @Operation(summary = SwaggerConstant.OPERATION_SAVE_API + SwaggerConstant.NAME_USER)
    ApiResponse createUser(CreateAccountDto createAccountDto);

    @Operation(summary = SwaggerConstant.OPERATION_UPDATE_API + SwaggerConstant.NAME_USER)
    ApiResponse updateUser(Long id, UpdateAccountDto updateUserDto);

    @Operation(summary = SwaggerConstant.OPERATION_GET_API + SwaggerConstant.NAME_USER)
    ApiResponse findUserById(Long id);

    @Operation(summary = SwaggerConstant.OPERATION_GET_INFO_API + SwaggerConstant.NAME_USER)
    ApiResponse getUserInfo();

    @Operation(summary = SwaggerConstant.OPERATION_DELETE_API + SwaggerConstant.NAME_USER)
    ApiResponse deleteUser(Long id);
}
