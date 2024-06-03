package com.microserives.service;

import com.microserives.dto.request.CreatePermissionDto;
import com.microserives.dto.request.CreateRoleDto;
import com.microserives.dto.request.UpdatePermissionDto;
import com.microserives.dto.request.UpdateRoleDto;
import com.microserives.dto.request.UpdateUserDto;
import com.microserives.dto.response.PermissionDto;
import com.microserives.dto.response.RoleDto;

import java.util.List;

/**
 * IRoleService
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */
public interface IRoleService {
    List<RoleDto> findAllRole();
    RoleDto createRole(CreateRoleDto createRoleDto);
    RoleDto updateRole(UpdateRoleDto updateRoleDto);
    RoleDto findRoleById(Long id);
    void deleteRole(Long id);
}
