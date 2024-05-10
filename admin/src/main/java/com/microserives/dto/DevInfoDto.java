package com.microserives.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * DevInfoDto
 *
 * @author haoln
 * @version 01-00
 * @since 5/9/2024
 */
@Getter
@Setter
public class DevInfoDto extends AbstractDate {
    private Long id;
    private String name;
    private Date age;
}
