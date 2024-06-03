package com.microserives.rest.impl;

import com.microserives.common.MessageCommon;
import com.microserives.common.RequestMappingCommon;
import com.microserives.dto.config.ApiResponse;
import com.microserives.dto.request.CreateUserDto;
import com.microserives.dto.request.UpdateUserDto;
import com.microserives.rest.IApiUserRest;
import com.microserives.service.IUserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping(RequestMappingCommon.URL_V1  + RequestMappingCommon.URL_USER)
@Slf4j
public class ApiUserRestImpl implements IApiUserRest {

    IUserService iUserService;

    @Override
    @GetMapping(RequestMappingCommon.URL_LIST)
    public ApiResponse findAllUser() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("username: {}", auth.getName());
        auth.getAuthorities().forEach(authority -> log.info("authority: {}", authority));
        return ApiResponse.builder()
                .data(iUserService.findAllUser())
                .build();
    }

    @Override
    @PostMapping(RequestMappingCommon.URL_SAVE)
    public ApiResponse createUser(@RequestBody @Valid CreateUserDto createUserDto) {
        return ApiResponse.builder()
                .data(iUserService.createUser(createUserDto))
                .message(MessageCommon.FIND_ALL_SUCCESS)
                .build();
    }

    @Override
    @PutMapping(RequestMappingCommon.URL_UPDATE + RequestMappingCommon.PATH_ID)
    public ApiResponse updateUser(@PathVariable(name = "id") Long id, @RequestBody UpdateUserDto updateUserDto) {
        updateUserDto.setId(id);
        return ApiResponse.builder()
                .data(iUserService.updateUser(updateUserDto))
                .message(MessageCommon.UPDATE_SUCCESS)
                .build();
    }

    @Override
    @GetMapping(RequestMappingCommon.URL_DETAIL + RequestMappingCommon.PATH_ID)
    public ApiResponse findUserById(@PathVariable(name = "id") Long id) {
        return ApiResponse.builder()
                .data(iUserService.findUserById(id))
                .message(MessageCommon.FIND_BY_ID_SUCCESS)
                .build();
    }

    @Override
    @GetMapping(RequestMappingCommon.URL_DETAIL + RequestMappingCommon.URL_INFO)
    public ApiResponse getUserInfo() {
        return ApiResponse.builder()
                .data(iUserService.getUserInfo())
                .message(MessageCommon.FIND_INFO_SUCCESS)
                .build();
    }

    @Override
    @DeleteMapping(RequestMappingCommon.URL_DELETE + RequestMappingCommon.PATH_ID)
    public ApiResponse deleteUser(@PathVariable(name = "id") Long id) {
        iUserService.deleteUser(id);
        return ApiResponse.builder()
                .data(null)
                .message(MessageCommon.DELETED_SUCCESS)
                .build();
    }
}
