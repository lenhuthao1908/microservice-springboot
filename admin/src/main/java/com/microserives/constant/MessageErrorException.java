package com.microserives.constant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageErrorException {
    public static final String NOT_FOUND = "not found";
    public static final String UNAUTHENTICATED = "unauthenticated";
}
