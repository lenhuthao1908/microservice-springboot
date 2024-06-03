package com.microserives.service.impl;

import com.microserives.constant.MessageErrorException;
import com.microserives.dto.request.CreateRoleDto;
import com.microserives.dto.request.UpdateRoleDto;
import com.microserives.dto.response.RoleDto;
import com.microserives.entity.RoleEntity;
import com.microserives.exception.AppException;
import com.microserives.mapper.RoleMapper;
import com.microserives.repository.PermissionRepository;
import com.microserives.repository.RoleRepository;
import com.microserives.service.IRoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

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
    RoleMapper roleMapper;

    @Override
    public List<RoleDto> findAllRole() {
        var list = roleRepository.findAll();
        return roleMapper.INSTANCE.toRoleDtos(list);
    }

    @Override
    public RoleDto createRole(CreateRoleDto createRoleDto) {
        var role = roleMapper.toRoleEntity(createRoleDto);
        role.setCreatedDate(new Date());
        var permissions = permissionRepository.findAllByPermissionNameIn(createRoleDto.getPermissions());
        role.setPermissions(new HashSet<>(permissions));
        return roleMapper.INSTANCE.toRoleDto(roleRepository.save(role));
    }

    @Override
    public RoleDto updateRole(UpdateRoleDto updateRoleDto) {
        var findRole = roleRepository.findById(updateRoleDto.getId())
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        var role = roleMapper.INSTANCE.toRoleEntity(findRole, updateRoleDto);
        var permissions = permissionRepository.findAllByPermissionNameIn(updateRoleDto.getPermissions());
        role.setPermissions(new HashSet<>(permissions));
        role.setUpdatedDate(new Date());
        return roleMapper.INSTANCE.toRoleDto(role);
    }

    @Override
    public RoleDto findRoleById(Long id) {
        var findRole = roleRepository.findById(id)
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        return roleMapper.toRoleDto(findRole);
    }

    @Override
    public void deleteRole(Long id) {
        var findRole = roleRepository.findById(id)
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        findRole.setDeletedDate(new Date());
        roleRepository.save(findRole);
    }
}
