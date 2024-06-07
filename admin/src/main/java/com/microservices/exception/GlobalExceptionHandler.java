package com.microservices.exception;

import com.microservices.dto.config.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlerRuntimeException(RuntimeException exception) {
        log.error(String.valueOf(exception));
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        ApiResponse.builder()
                                .code(ErrorCode.SERVICE_ERROR.getCode())
                                .message(exception.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlerAppException(AppException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ApiResponse.builder()
                                .code(ErrorCode.BAD_REQUEST.getCode())
                                .message(exception.getMessage())
                                .build()
                );
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ApiResponse.builder()
                                .code(ErrorCode.BAD_REQUEST.getCode())
                                .message(Objects.requireNonNull(exception.getFieldError()).getDefaultMessage())
                                .build()
                );
    }

    @ExceptionHandler(value = { AccessDeniedException.class })
    ResponseEntity<ApiResponse> handlerAccessDeniedException(AccessDeniedException exception) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(
                        ApiResponse.builder()
                                .code(ErrorCode.FORBIDDEN.getCode())
                                .message(exception.getMessage())
                                .build()
                );
    }
}
