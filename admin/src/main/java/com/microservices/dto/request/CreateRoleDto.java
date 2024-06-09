package com.microservices.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * CreateRoleDto
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateRoleDto {
    String roleName;
    String roleDescription;
    List<String> permissions;
}
