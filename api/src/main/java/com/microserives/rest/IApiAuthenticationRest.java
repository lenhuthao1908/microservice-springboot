package com.microserives.rest;

import com.microserives.dto.config.ApiResponse;
import com.microserives.dto.request.AuthenticationRequestDto;
import com.microserives.dto.request.IntrospectRequestDto;

public interface IApiAuthenticationRest {
    ApiResponse authentication(AuthenticationRequestDto authenticationRequestDto);

    ApiResponse authenticationRefresh(String refreshToke, String accessToken);

    ApiResponse authentication(IntrospectRequestDto introspectRequestDto);
}
