package com.microserives.mapper;

import com.microserives.dto.request.CreatePermissionDto;
import com.microserives.dto.request.CreateUserDto;
import com.microserives.dto.request.UpdatePermissionDto;
import com.microserives.dto.request.UpdateUserDto;
import com.microserives.dto.response.PermissionDto;
import com.microserives.dto.response.UserDto;
import com.microserives.entity.PermissionEntity;
import com.microserives.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * PermissionMapper
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    PermissionMapper INSTANCE = Mappers.getMapper(PermissionMapper.class);

    PermissionEntity toPermissionEntity(CreatePermissionDto createPermissionDto);
    PermissionDto toPermissionDto(PermissionEntity permissionEntity);
    List<PermissionDto> toPermissionDtos(List<PermissionEntity> permissionEntities);
    PermissionEntity toPermissionEntity(@MappingTarget PermissionEntity permissionEntity, UpdatePermissionDto updatePermissionDto);
}
