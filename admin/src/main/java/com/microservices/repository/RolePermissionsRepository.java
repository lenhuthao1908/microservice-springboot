package com.microservices.repository;

import com.microservices.config.miragesql.repository.DbRepository;
import com.microservices.entity.RolePermissionsEntity;

/**
 * RolePermissionsRepository
 *
 * @author haoln
 * @version 01-00
 * @since 6/8/2024
 */
public interface RolePermissionsRepository extends DbRepository<RolePermissionsEntity, Long> {
}
