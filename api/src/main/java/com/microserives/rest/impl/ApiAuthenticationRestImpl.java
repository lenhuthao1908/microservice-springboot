package com.microserives.rest.impl;

import com.microserives.common.RequestMappingCommon;
import com.microserives.dto.config.ApiResponse;
import com.microserives.dto.request.AuthenticationRequestDto;
import com.microserives.dto.request.IntrospectRequestDto;
import com.microserives.rest.IApiAuthenticationRest;
import com.microserives.service.IAuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                .data(iAuthenticationService.authenticate(authenticationRequestDto))
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
    public ApiResponse authentication(@RequestBody IntrospectRequestDto introspectRequestDto) {
        return ApiResponse.builder()
                .data(iAuthenticationService.introspect(introspectRequestDto))
                .build();
    }
}
