package com.microserives.mapper;

import com.microserives.dto.request.CreateRoleDto;
import com.microserives.dto.request.UpdateRoleDto;
import com.microserives.dto.response.PermissionDto;
import com.microserives.dto.response.RoleDto;
import com.microserives.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * RoleMapper
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    @Mapping(target = "permissions", ignore = true)
    RoleEntity toRoleEntity(CreateRoleDto createRoleDto);
    RoleDto toRoleDto(RoleEntity roleEntity);
    List<RoleDto> toRoleDtos(List<RoleEntity> roleEntities);

    @Mapping(target = "permissions", ignore = true)
    RoleEntity toRoleEntity(@MappingTarget RoleEntity roleEntity, UpdateRoleDto updateRoleDto);
}
