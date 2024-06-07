package com.microservices.service;

import com.microservices.dto.request.AuthenticationRequestDto;
import com.microservices.dto.request.IntrospectRequestDto;
import com.microservices.dto.request.LogoutDto;
import com.microservices.dto.response.AuthenticationResponseDto;
import com.microservices.dto.response.IntrospectResponseDto;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface IAuthenticationService {
     AuthenticationResponseDto authenticate(AuthenticationRequestDto authenticationRequestDto);
    void logout(LogoutDto logoutDto) throws ParseException;
    AuthenticationResponseDto refreshToken(String refreshToken, String currentAccessToken);
    IntrospectResponseDto introspect(IntrospectRequestDto introspectRequestDto) throws JOSEException, ParseException;
}
