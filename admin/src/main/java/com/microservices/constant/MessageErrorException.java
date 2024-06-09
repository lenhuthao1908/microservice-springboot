package com.microservices.constant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageErrorException {
    public static final String NOT_FOUND = "not found";
    public static final String UNAUTHENTICATED = "unauthenticated";
    public static final String EXPIRED_TOKEN = "Expired token";
    public static final String TOKEN_ISVALID = "Token is valid";
}
