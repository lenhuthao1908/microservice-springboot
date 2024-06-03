package com.microserives.config;

import com.microserives.common.ConstantCommon;
import com.microserives.entity.UserEntity;
import com.microserives.enums.RolesEnum;
import com.microserives.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

@Configuration
@Slf4j
public class ApplicationConfig {
    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
            Optional<UserEntity> adminUserOpt = userRepository.findByUsername("admin");
            if (adminUserOpt.isEmpty()) {
                HashSet<String> roles = new HashSet<>();
                roles.add(RolesEnum.ADMIN.name());
                UserEntity adminDefault = UserEntity.builder()
                        .username("admin")
                        .password(new BCryptPasswordEncoder(ConstantCommon.STRENGTH_PASSWORD).encode("123123"))
                        .createdDate(new Date())
                        // .roles(roles)
                        .build();
                userRepository.save(adminDefault);
                log.info("Create account ADMIN default with username: admin, password: 123123, created date: {}", adminDefault.getCreatedDate());
            }
        };
    }
}
