package com.microserives.dto.response;

import com.microserives.dto.AbstractDateDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * PermissionDto
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PermissionDto extends AbstractDateDto {
    Long id;
    String permissionName;
    String permissionDescription;
}
