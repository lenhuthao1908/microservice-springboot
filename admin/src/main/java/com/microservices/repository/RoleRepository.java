package com.microservices.repository;

import com.microservices.config.miragesql.repository.DbRepository;
import com.microservices.entity.RoleEntity;

/**
 * RoleRepository
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */
public interface RoleRepository extends DbRepository<RoleEntity, Long> {
    //List<RoleDto> getAllRole();
}
