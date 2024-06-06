package com.microserives.repository;

import com.microserives.config.miragesql.repository.DbRepository;
import com.microserives.dto.response.UserDto;
import com.microserives.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends DbRepository<UserEntity, Long> {
    // boolean existsByUsername(String username);
    // Optional<UserEntity> findByUsername(String username);
    //
    // List<UserDto> getListUser();

}
