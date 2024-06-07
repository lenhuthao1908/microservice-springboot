package com.microservices.repository;

import com.microservices.config.miragesql.repository.DbRepository;
import com.microservices.dto.response.PermissionDto;
import com.microservices.entity.PermissionEntity;

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
