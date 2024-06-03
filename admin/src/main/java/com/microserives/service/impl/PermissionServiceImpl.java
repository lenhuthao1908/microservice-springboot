package com.microserives.service.impl;

import com.microserives.constant.MessageErrorException;
import com.microserives.dto.request.CreatePermissionDto;
import com.microserives.dto.request.UpdatePermissionDto;
import com.microserives.dto.response.PermissionDto;
import com.microserives.entity.PermissionEntity;
import com.microserives.exception.AppException;
import com.microserives.mapper.PermissionMapper;
import com.microserives.repository.PermissionRepository;
import com.microserives.service.IPermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    PermissionMapper permissionMapper;

    @Override
    public List<PermissionDto> findAllPermission() {
        var list = permissionRepository.findAll();
        return permissionMapper.INSTANCE.toPermissionDtos(list);
    }

    @Override
    public PermissionDto createPermission(CreatePermissionDto createPermissionDto) {
        var entity = permissionMapper.toPermissionEntity(createPermissionDto);
        entity.setCreatedDate(new Date());
        return permissionMapper.INSTANCE.toPermissionDto(permissionRepository.save(entity));
    }

    @Override
    public PermissionDto updatePermission(UpdatePermissionDto updatePermissionDto) {
        var findPermission = permissionRepository.findById(updatePermissionDto.getId())
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        var entity = permissionMapper.INSTANCE.toPermissionEntity(findPermission, updatePermissionDto);
        entity.setUpdatedDate(new Date());
        return permissionMapper.toPermissionDto(permissionRepository.save(entity));
    }

    @Override
    public PermissionDto findPermissionById(Long id) {
        var findPermission = permissionRepository.findById(id)
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        return permissionMapper.INSTANCE.toPermissionDto(findPermission);
    }

    @Override
    public void deletePermission(Long id) {
        var findPermission = permissionRepository.findById(id)
                .orElseThrow(() -> new AppException(MessageErrorException.NOT_FOUND));
        findPermission.setDeletedDate(new Date());
        permissionRepository.save(findPermission);
    }
}
