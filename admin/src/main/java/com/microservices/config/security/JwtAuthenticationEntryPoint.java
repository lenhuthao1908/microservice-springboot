package com.microservices.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.config.common.ConstantSecurityCommon;
import com.microservices.dto.config.ApiResponse;
import com.microservices.exception.ErrorCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

/**
 * JwtAuthenticationEntryPoint
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;

        response.setStatus(errorCode.getHttpStatusCode().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        ApiResponse apiResponse = ApiResponse.builder()
                .code(errorCode.getCode())
                .message(ConstantSecurityCommon.UNAUTHORIZED)
                .build();

        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
        response.flushBuffer();
    }
}
