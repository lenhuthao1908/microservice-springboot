package com.microservices.service;

import com.microservices.dto.request.CreateRoleDto;
import com.microservices.dto.request.UpdateRoleDto;
import com.microservices.dto.response.RoleDto;

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
