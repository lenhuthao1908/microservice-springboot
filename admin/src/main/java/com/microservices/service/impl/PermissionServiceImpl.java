package com.microservices.service.impl;

import com.microservices.constant.MessageErrorException;
import com.microservices.dto.request.CreatePermissionDto;
import com.microservices.dto.request.UpdatePermissionDto;
import com.microservices.dto.response.PermissionDto;
import com.microservices.entity.PermissionEntity;
import com.microservices.exception.AppException;
import com.microservices.repository.PermissionRepository;
import com.microservices.service.IPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * PermissionServiceImpl
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */

@Service
@Slf4j
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public List<PermissionDto> findAllPermission() {
        return permissionRepository.getAllPermission();
    }

    @Override
    public PermissionDto createPermission(CreatePermissionDto createPermissionDto) {
        var entityMapper = PermissionEntity.builder()
                .permissionName(createPermissionDto.getPermissionName())
                .permissionDescription(createPermissionDto.getPermissionDescription())
                .createdDate(new Date())
                .build();
        var entity = permissionRepository.create(entityMapper);
        return PermissionDto.builder()
                .id(entity.getId())
                .permissionName(entity.getPermissionName())
                .permissionDescription(entity.getPermissionDescription())
                .createdDate(entity.getCreatedDate())
                .build();
    }

    @Override
    public PermissionDto updatePermission(UpdatePermissionDto updatePermissionDto) {
        var findPermission = permissionRepository.findOne(updatePermissionDto.getId());
        if(Objects.isNull(findPermission)) {
            throw new AppException(MessageErrorException.NOT_FOUND);
        }
        findPermission.setPermissionName(updatePermissionDto.getPermissionName());
        findPermission.setPermissionDescription(updatePermissionDto.getPermissionDescription());
        findPermission.setUpdatedDate(new Date());
        permissionRepository.update(findPermission);
        return PermissionDto.builder()
                .permissionName(findPermission.getPermissionName())
                .permissionDescription(findPermission.getPermissionDescription())
                .createdDate(findPermission.getCreatedDate())
                .updatedDate(findPermission.getUpdatedDate())
                .build();
    }

    @Override
    public PermissionDto findPermissionById(Long id) {
        var findPermission = permissionRepository.findOne(id);
        if(Objects.isNull(findPermission)) {
            throw new AppException(MessageErrorException.NOT_FOUND);
        }
        return PermissionDto.builder()
                .permissionName(findPermission.getPermissionName())
                .permissionDescription(findPermission.getPermissionDescription())
                .createdDate(findPermission.getCreatedDate())
                .updatedDate(findPermission.getUpdatedDate())
                .build();
    }

    @Override
    public void deletePermission(Long id) {
        var findPermission = permissionRepository.findOne(id);
        if(Objects.isNull(findPermission)) {
            throw new AppException(MessageErrorException.NOT_FOUND);
        }
        findPermission.setDeletedDate(new Date());
        permissionRepository.update(findPermission);
    }
}
