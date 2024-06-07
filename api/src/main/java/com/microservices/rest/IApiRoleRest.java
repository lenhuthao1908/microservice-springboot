package com.microservices.rest;

import com.microservices.dto.config.ApiResponse;
import com.microservices.dto.request.CreateRoleDto;
import com.microservices.dto.request.UpdateRoleDto;

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
