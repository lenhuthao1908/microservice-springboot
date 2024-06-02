package com.microserives.exception;

import com.microserives.dto.config.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlerRuntimeException(RuntimeException exception) {
        return ResponseEntity
                .internalServerError()
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
                .badRequest()
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
                .badRequest()
                .body(
                        ApiResponse.builder()
                                .code(ErrorCode.BAD_REQUEST.getCode())
                                .message(Objects.requireNonNull(exception.getFieldError()).getDefaultMessage())
                                .build()
                );
    }
}
