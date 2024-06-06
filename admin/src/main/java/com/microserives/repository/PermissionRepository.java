package com.microserives.repository;

import com.microserives.config.miragesql.repository.DbRepository;
import com.microserives.dto.response.PermissionDto;
import com.microserives.entity.PermissionEntity;

import java.util.List;

/**
 * PermissionRepository
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */
public interface PermissionRepository extends DbRepository<PermissionEntity, Long> {

    List<PermissionDto> getAllPermission();
}
