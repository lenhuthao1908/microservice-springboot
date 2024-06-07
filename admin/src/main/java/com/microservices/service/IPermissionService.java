package com.microservices.service;

import com.microservices.dto.request.CreatePermissionDto;
import com.microservices.dto.request.UpdatePermissionDto;
import com.microservices.dto.response.PermissionDto;

import java.util.List;

/**
 * IPermissionService
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */
public interface IPermissionService {
    List<PermissionDto> findAllPermission();
    PermissionDto createPermission(CreatePermissionDto createPermissionDto);
    PermissionDto updatePermission(UpdatePermissionDto updatePermissionDto);
    PermissionDto findPermissionById(Long id);
    void deletePermission(Long id);
}
