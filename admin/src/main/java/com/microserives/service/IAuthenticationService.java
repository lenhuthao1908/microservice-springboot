package com.microserives.service;

import com.microserives.dto.request.AuthenticationRequestDto;
import com.microserives.dto.request.IntrospectRequestDto;
import com.microserives.dto.request.LogoutDto;
import com.microserives.dto.response.AuthenticationResponseDto;
import com.microserives.dto.response.IntrospectResponseDto;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface IAuthenticationService {
    AuthenticationResponseDto authenticate(AuthenticationRequestDto  authenticationRequestDto);
    void logout(LogoutDto logoutDto) throws ParseException;
    AuthenticationResponseDto refreshToken(String refreshToken, String currentAccessToken);
    IntrospectResponseDto introspect(IntrospectRequestDto introspectRequestDto) throws JOSEException, ParseException;
}
