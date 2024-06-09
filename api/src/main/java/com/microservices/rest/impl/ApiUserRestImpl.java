package com.microservices.rest.impl;

import com.microservices.common.MessageCommon;
import com.microservices.common.RequestMappingCommon;
import com.microservices.dto.config.ApiResponse;
import com.microservices.dto.request.CreateAccountDto;
import com.microservices.dto.request.UpdateAccountDto;
import com.microservices.rest.IApiUserRest;
import com.microservices.service.IAccountService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping(RequestMappingCommon.URL_V1  + RequestMappingCommon.URL_USER)
@Slf4j
public class ApiUserRestImpl implements IApiUserRest {

    IAccountService iAccountService;

    @Override
    @GetMapping(RequestMappingCommon.URL_LIST)
    public ApiResponse findAllUser() {
//        var auth = SecurityContextHolder.getContext().getAuthentication();
//        log.info("username: {}", auth.getName());
//        auth.getAuthorities().forEach(authority -> log.info("authority: {}", authority));
        return ApiResponse.builder()
                .data(iAccountService.findAllUser())
                .build();
    }

    @Override
    @PostMapping(RequestMappingCommon.URL_SAVE)
    public ApiResponse createUser(@RequestBody @Valid CreateAccountDto createAccountDto) {
        return ApiResponse.builder()
                .data(iAccountService.createUser(createAccountDto))
                .message(MessageCommon.FIND_ALL_SUCCESS)
                .build();
    }

    @Override
    @PutMapping(RequestMappingCommon.URL_UPDATE + RequestMappingCommon.PATH_ID)
    public ApiResponse updateUser(@PathVariable(name = "id") Long id, @RequestBody UpdateAccountDto updateUserDto) {
        updateUserDto.setId(id);
        return ApiResponse.builder()
                .data(iAccountService.updateUser(updateUserDto))
                .message(MessageCommon.UPDATE_SUCCESS)
                .build();
    }

    @Override
    @GetMapping(RequestMappingCommon.URL_DETAIL + RequestMappingCommon.PATH_ID)
    public ApiResponse findUserById(@PathVariable(name = "id") Long id) {
        return ApiResponse.builder()
                .data(iAccountService.findUserById(id))
                .message(MessageCommon.FIND_BY_ID_SUCCESS)
                .build();
    }

    @Override
    @GetMapping(RequestMappingCommon.URL_DETAIL + RequestMappingCommon.URL_INFO)
    public ApiResponse getUserInfo() {
        return ApiResponse.builder()
                .data(iAccountService.getUserInfo())
                .message(MessageCommon.FIND_INFO_SUCCESS)
                .build();
    }

    @Override
    @DeleteMapping(RequestMappingCommon.URL_DELETE + RequestMappingCommon.PATH_ID)
    public ApiResponse deleteUser(@PathVariable(name = "id") Long id) {
        iAccountService.deleteUser(id);
        return ApiResponse.builder()
                .data(null)
                .message(MessageCommon.DELETED_SUCCESS)
                .build();
    }
}
