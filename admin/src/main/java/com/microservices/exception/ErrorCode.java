package com.microservices.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public enum ErrorCode {
    SERVICE_ERROR(500, HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(400, HttpStatus.BAD_REQUEST),
    FORBIDDEN(403, HttpStatus.FORBIDDEN),
    UNAUTHORIZED(401, HttpStatus.UNAUTHORIZED),
    INVALID_KEY(400, HttpStatus.BAD_REQUEST)

    ;

    int code;
    HttpStatusCode httpStatusCode;
}
