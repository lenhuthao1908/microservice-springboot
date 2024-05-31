package com.microserives.dto.request;

import com.microserives.dto.AbstractDateDto;
import lombok.Getter;
import lombok.Setter;


/**
 * CreateDevInfoDto
 *
 * @author haoln
 * @version 01-00
 * @since 5/9/2024
 */
@Getter
@Setter
public class CreateDevInfoDto extends AbstractDateDto {
    private String name;
}
