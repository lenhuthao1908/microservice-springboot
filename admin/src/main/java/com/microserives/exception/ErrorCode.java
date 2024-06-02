package com.microserives.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public enum ErrorCode {
    SERVICE_ERROR(500),
    BAD_REQUEST(400)
    ;

    int code;
}
