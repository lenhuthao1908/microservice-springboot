package com.microservices.rest.impl;

import com.microservices.common.MessageCommon;
import com.microservices.common.RequestMappingCommon;
import com.microservices.dto.config.ApiResponse;
import com.microservices.dto.request.AuthenticationRequestDto;
import com.microservices.dto.request.IntrospectRequestDto;
import com.microservices.dto.request.LogoutDto;
import com.microservices.rest.IApiAuthenticationRest;
import com.microservices.service.IAuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping(RequestMappingCommon.URL_V1 + RequestMappingCommon.URL_AUTH)
@Slf4j
public class ApiAuthenticationRestImpl implements IApiAuthenticationRest {

    IAuthenticationService iAuthenticationService;

    @Override
    @PostMapping(RequestMappingCommon.URL_LOGIN)
    public ApiResponse authentication(@RequestBody AuthenticationRequestDto authenticationRequestDto ) {
        return ApiResponse.builder()
                .message(MessageCommon.LOGIN_SUCCESS)
                .data(iAuthenticationService.authenticate(authenticationRequestDto))
                .build();
    }

    @Override
    @PostMapping(RequestMappingCommon.URL_LOGOUT)
    public ApiResponse logout(@RequestBody LogoutDto logoutDto) throws ParseException {
        iAuthenticationService.logout(logoutDto);
        return ApiResponse.builder()
                .message(MessageCommon.LOGOUT_SUCCESS)
                .data(null)
                .build();
    }

    @Override
    @PostMapping(RequestMappingCommon.URL_REFRESH)
    public ApiResponse authenticationRefresh(@RequestBody String refreshToke, String accessToken) {
        return ApiResponse.builder()
                .data(iAuthenticationService.refreshToken(refreshToke, accessToken))
                .build();
    }

    @Override
    @PostMapping(RequestMappingCommon.URL_CHECK_TOKEN)
    public ApiResponse authentication(@RequestBody IntrospectRequestDto introspectRequestDto) throws Exception {
        return ApiResponse.builder()
                .data(null)
                .build();
    }
}
