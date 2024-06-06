package com.microserives.repository;

import com.microserives.config.miragesql.repository.DbRepository;
import com.microserives.entity.InvalidateTokenEntity;


/**
 * InvalidateTokenRepository
 *
 * @author haoln
 * @version 01-00
 * @since 6/4/2024
 */
public interface InvalidateTokenRepository extends DbRepository<InvalidateTokenEntity, Long> {
    // boolean existsByCode(String code);
}
