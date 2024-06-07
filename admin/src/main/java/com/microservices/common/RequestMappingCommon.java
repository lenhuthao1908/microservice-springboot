package com.microservices.common;

import org.springframework.stereotype.Component;

@Component
public class RequestMappingCommon {

    // PATH_VARIABLE
    public static final String PATH_ID = "/{id}";

    // URL
    public static final String URL_V1 = "api/v1";
    public static final String URL_USER = "/user";
    public static final String URL_AUTH = "/auth";
    public static final String URL_ROLE = "/role";
    public static final String URL_PERMISSION = "/permission";

    // URL REST
    public static final String URL_SAVE = "/save";
    public static final String URL_UPDATE = "/update";
    public static final String URL_DELETE = "/delete";
    public static final String URL_DETAIL = "/detail";
    public static final String URL_LIST = "/list";
    public static final String URL_LOGIN = "/login";
    public static final String URL_LOGOUT = "/logout";
    public static final String URL_REFRESH = "/refresh";
    public static final String URL_CHECK_TOKEN = "/check-token";
    public static final String URL_INFO = "/info";
}
