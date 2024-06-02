package com.microserives.service;

import com.microserives.dto.request.AuthenticationRequestDto;
import com.microserives.dto.request.IntrospectRequestDto;
import com.microserives.dto.response.AuthenticationResponseDto;
import com.microserives.dto.response.IntrospectResponseDto;

public interface IAuthenticationService {
    AuthenticationResponseDto authenticate(AuthenticationRequestDto  authenticationRequestDto);
    public AuthenticationResponseDto refreshToken(String refreshToken, String currentAccessToken);
    IntrospectResponseDto introspect(IntrospectRequestDto introspectRequestDto);
}
