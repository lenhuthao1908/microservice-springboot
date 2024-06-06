package com.microserives.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.microserives.constant.MessageErrorException;
import com.microserives.dto.request.CreateRoleDto;
import com.microserives.dto.request.UpdateRoleDto;
import com.microserives.dto.response.PermissionDto;
import com.microserives.dto.response.RoleDto;
import com.microserives.entity.RoleEntity;
import com.microserives.exception.AppException;
// import com.microserives.mapper.RoleMapper;
import com.microserives.repository.PermissionRepository;
import com.microserives.repository.RoleRepository;
import com.microserives.service.IRoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * RoleServiceImpl
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImpl implements IRoleService {
    RoleRepository roleRepository;
    PermissionRepository permissionRepository;
    // RoleMapper roleMapper;

    @Override
    public List<RoleDto> findAllRole() {
        return null;
    }

    @Override
    public RoleDto createRole(CreateRoleDto createRoleDto) {
        var entityMapper = RoleEntity.builder()
                .roleName(createRoleDto.getRoleName())
                .roleDescription(createRoleDto.getRoleDescription())
                .createdDate(new Date())
                .build();
        var entity = roleRepository.create(entityMapper);
        return RoleDto.builder()
                .id(entity.getId())
                .roleName(entity.getRoleName())
                .roleDescription(entityMapper.getRoleDescription())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    @Override
    public RoleDto updateRole(UpdateRoleDto updateRoleDto) {
        var findRole = roleRepository.findOne(updateRoleDto.getId());
        if(Objects.isNull(findRole)) {
            throw new AppException(MessageErrorException.NOT_FOUND);
        }
        findRole.setRoleName(updateRoleDto.getRoleName());
        findRole.setRoleDescription(updateRoleDto.getRoleDescription());
        findRole.setUpdatedDate(new Date());
        roleRepository.update(findRole);
        return RoleDto.builder()
                .id(findRole.getId())
                .roleName(findRole.getRoleName())
                .roleDescription(findRole.getRoleDescription())
                .createdDate(findRole.getCreatedDate())
                .updatedDate(findRole.getUpdatedDate())
                .build();
    }

    @Override
    public RoleDto findRoleById(Long id) {
        var findRole = roleRepository.findOne(id);
        if(Objects.isNull(findRole)) {
            throw new AppException(MessageErrorException.NOT_FOUND);
        }
        return RoleDto.builder()
                .id(findRole.getId())
                .roleName(findRole.getRoleName())
                .roleDescription(findRole.getRoleDescription())
                .createdDate(findRole.getCreatedDate())
                .updatedDate(findRole.getUpdatedDate())
                .build();
    }

    @Override
    public void deleteRole(Long id) {
        var findRole = roleRepository.findOne(id);
        if(Objects.isNull(findRole)) {
            throw new AppException(MessageErrorException.NOT_FOUND);
        }
        findRole.setDeletedDate(new Date());
        roleRepository.save(findRole);
    }
}
