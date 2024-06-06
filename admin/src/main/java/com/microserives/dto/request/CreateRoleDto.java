package com.microserives.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Set;

/**
 * CreateRoleDto
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
public class CreateRoleDto {
    String roleName;
    String roleDescription;
    List<String> permissions;
}
