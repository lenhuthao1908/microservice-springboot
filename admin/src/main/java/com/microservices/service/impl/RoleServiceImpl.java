package com.microservices.service.impl;

import com.microservices.constant.MessageErrorException;
import com.microservices.dto.request.CreateRoleDto;
import com.microservices.dto.request.UpdateRoleDto;
import com.microservices.dto.response.RoleDto;
import com.microservices.entity.RoleEntity;
import com.microservices.exception.AppException;
import com.microservices.repository.PermissionRepository;
import com.microservices.repository.RoleRepository;
import com.microservices.service.IRoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
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
