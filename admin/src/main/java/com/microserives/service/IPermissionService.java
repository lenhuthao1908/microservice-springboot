package com.microserives.service;

import com.microserives.dto.request.CreatePermissionDto;
import com.microserives.dto.request.CreateUserDto;
import com.microserives.dto.request.UpdatePermissionDto;
import com.microserives.dto.request.UpdateUserDto;
import com.microserives.dto.response.PermissionDto;
import com.microserives.dto.response.UserDto;

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
