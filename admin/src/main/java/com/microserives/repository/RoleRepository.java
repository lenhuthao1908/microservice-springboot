package com.microserives.repository;

import com.microserives.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * RoleRepository
 *
 * @author haoln
 * @version 01-00
 * @since 6/3/2024
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
}
