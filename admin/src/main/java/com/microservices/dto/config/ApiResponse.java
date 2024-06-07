package com.microservices.dto.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PACKAGE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    @Builder.Default
    int code = 200;
    String message;
    Object data;
}
