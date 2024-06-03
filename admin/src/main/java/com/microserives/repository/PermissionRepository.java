package com.microserives.repository;

import com.microserives.entity.PermissionEntity;
import com.microserives.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * PermissionRepository
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */
public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
    List<PermissionEntity> findAllByPermissionNameIn(Iterable<String> permissionNames);
}
