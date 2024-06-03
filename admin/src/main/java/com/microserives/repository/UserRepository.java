package com.microserives.repository;

import com.microserives.dto.response.UserDto;
import com.microserives.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername(String username);
    Optional<UserEntity> findByUsername(String username);

    @Query(value = "select uf.username, uf.password from user_info uf", nativeQuery = true)
    List<UserDto> getListUser();

}
