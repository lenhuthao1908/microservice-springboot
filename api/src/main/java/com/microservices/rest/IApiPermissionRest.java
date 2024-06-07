package com.microservices.rest;

import com.microservices.dto.config.ApiResponse;
import com.microservices.dto.request.CreatePermissionDto;
import com.microservices.dto.request.UpdatePermissionDto;

/**
 * IApiPermissionRest
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */
public interface IApiPermissionRest {
    ApiResponse findAllPermission();

    ApiResponse createPermission(CreatePermissionDto createPermissionDto);

    ApiResponse updatePermission(Long id, UpdatePermissionDto updatePermissionDto);

    ApiResponse findPermissionById(Long id);

    ApiResponse deletePermission(Long id);
}
