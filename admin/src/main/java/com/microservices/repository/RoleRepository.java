package com.microservices.repository;

import com.microservices.config.miragesql.repository.DbRepository;
import com.microservices.dto.response.RoleDto;
import com.microservices.entity.RoleEntity;

import java.util.List;

/**
 * RoleRepository
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */
public interface RoleRepository extends DbRepository<RoleEntity, Long> {
    List<RoleDto> getAllRole();
}
