package com.microserives.repository;

import com.microserives.config.miragesql.repository.DbRepository;
import com.microserives.dto.response.RoleDto;
import com.microserives.entity.RoleEntity;

import java.util.List;

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
