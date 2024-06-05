package com.microserives.common;

import org.springframework.stereotype.Component;

/**
 * MessageCommon
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */

@Component
public class MessageCommon {

    // Message url response
    public static final String FIND_ALL_SUCCESS = "You have found all successfully!";
    public static final String SAVE_SUCCESS = "You have save it successfully!";
    public static final String UPDATE_SUCCESS = "You have updated it successfully!";
    public static final String FIND_BY_ID_SUCCESS = "You have found detail by id successfully!";
    public static final String FIND_INFO_SUCCESS = "You have found info detail successfully!";
    public static final String DELETED_SUCCESS = "You have deleted it successfully!";
    public static final String LOGOUT_SUCCESS = "You have logout successfully!";
    public static final String LOGIN_SUCCESS = "You have login successfully!";

    // Message validate field
    public static final String MINIMUM_3_CHARACTER = "Minimum 3 character";
    public static final String AGE_OLDER_THEN_18 = "age older than 18";

    // Message validate default annotation
    public static final String INVALID_DATE_OF_BIRTH = "Invalid date of birth";
}
