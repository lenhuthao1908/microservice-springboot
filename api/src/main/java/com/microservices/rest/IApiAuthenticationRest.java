package com.microservices.rest;

import com.microservices.dto.config.ApiResponse;
import com.microservices.dto.request.AuthenticationRequestDto;
import com.microservices.dto.request.IntrospectRequestDto;
import com.microservices.dto.request.LogoutDto;

import java.text.ParseException;

public interface IApiAuthenticationRest {
    ApiResponse authentication(AuthenticationRequestDto authenticationRequestDto);

    ApiResponse logout(LogoutDto logoutDto) throws ParseException;

    ApiResponse authenticationRefresh(String refreshToke, String accessToken);

    ApiResponse authentication(IntrospectRequestDto introspectRequestDto) throws Exception;
}
