package com.microserives.repository;

import com.microserives.entity.DevInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DevInfoRepository
 *
 * @author haoln
 * @version 01-00
 * @since 5/9/2024
 */
@Repository
public interface DevInfoRepository extends JpaRepository<DevInfoEntity, Long> {
}
