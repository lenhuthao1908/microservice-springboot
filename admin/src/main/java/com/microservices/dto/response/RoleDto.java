package com.microservices.dto.response;

import com.microservices.dto.AbstractDateDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleDto extends AbstractDateDto {
    Long id;
    String roleName;
    String roleDescription;
    Set<PermissionDto> permissions;
}
