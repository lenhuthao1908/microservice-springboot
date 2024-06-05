package com.microserives.rest;

import com.microserives.dto.config.ApiResponse;
import com.microserives.dto.request.AuthenticationRequestDto;
import com.microserives.dto.request.IntrospectRequestDto;
import com.microserives.dto.request.LogoutDto;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface IApiAuthenticationRest {
    ApiResponse authentication(AuthenticationRequestDto authenticationRequestDto);

    ApiResponse logout(LogoutDto logoutDto) throws ParseException;

    ApiResponse authenticationRefresh(String refreshToke, String accessToken);

    ApiResponse authentication(IntrospectRequestDto introspectRequestDto) throws ParseException, JOSEException;
}
