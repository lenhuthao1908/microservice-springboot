package com.microserives.service.impl;

import com.microserives.constant.MessageErrorException;
import com.microserives.dto.request.CreatePermissionDto;
import com.microserives.dto.request.UpdatePermissionDto;
import com.microserives.dto.response.PermissionDto;
import com.microserives.entity.PermissionEntity;
import com.microserives.exception.AppException;
// import com.microserives.mapper.PermissionMapper;
import com.microserives.repository.PermissionRepository;
import com.microserives.service.IPermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
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
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionServiceImpl implements IPermissionService {
    PermissionRepository permissionRepository;
    // PermissionMapper permissionMapper;

    @Override
    public List<PermissionDto> findAllPermission() {
        return null;
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
