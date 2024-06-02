package com.microserives.constant;

import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
public class MessageErrorException {
    public static final String NOT_FOUND = "not found";
    public static final String UNAUTHENTICATED = "unauthenticated";
}
