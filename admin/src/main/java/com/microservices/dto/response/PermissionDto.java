package com.microservices.dto.response;

import com.microservices.dto.AbstractDateDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * PermissionDto
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionDto extends AbstractDateDto {
    Long id;
    String permissionName;
    String permissionDescription;
}
