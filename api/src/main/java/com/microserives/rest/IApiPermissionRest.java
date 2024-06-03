package com.microserives.rest;

import com.microserives.dto.config.ApiResponse;
import com.microserives.dto.request.CreatePermissionDto;
import com.microserives.dto.request.UpdatePermissionDto;
import com.microserives.dto.response.PermissionDto;

import java.util.List;

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
