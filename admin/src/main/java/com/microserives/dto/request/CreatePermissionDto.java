package com.microserives.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

/**
 * CreatePermissionDto
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
public class CreatePermissionDto {
    String permissionName;
    String permissionDescription;
}
