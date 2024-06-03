package com.microserives.rest;

import com.microserives.dto.config.ApiResponse;
import com.microserives.dto.request.CreateRoleDto;
import com.microserives.dto.request.UpdateRoleDto;
import com.microserives.dto.response.RoleDto;

import java.util.List;

/**
 * IApiRoleRest
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */
public interface IApiRoleRest {
    ApiResponse findAllRole();

    ApiResponse createRole(CreateRoleDto createRoleDto);

    ApiResponse updateRole(Long id, UpdateRoleDto updateRoleDto);

    ApiResponse findRoleById(Long id);

    ApiResponse deleteRole(Long id);
}
