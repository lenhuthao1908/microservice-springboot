package com.microserives.repository;

import com.microserives.entity.InvalidateTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * InvalidateTokenRepository
 *
 * @author haoln
 * @version 01-00
 * @since 6/4/2024
 */
public interface InvalidateTokenRepository extends JpaRepository<InvalidateTokenEntity, Long> {
    boolean existsByCode(String code);
}
