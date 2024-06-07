package com.microservices.repository;

import com.microservices.config.miragesql.repository.DbRepository;
import com.microservices.entity.UserEntity;

public interface UserRepository extends DbRepository<UserEntity, Long> {
    // boolean existsByUsername(String username);
    // Optional<UserEntity> findByUsername(String username);
    //
    // List<UserDto> getListUser();

}
