package com.microserives.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * UpdateDevInfoDto
 *
 * @author haoln
 * @version 01-00
 * @since 5/9/2024
 */
@Getter
@Setter
public class UpdateDevInfoDto extends DevInfoDto {
    private int category;
}
