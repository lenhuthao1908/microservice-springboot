package com.microservices.config;

import com.microservices.common.ConstantCommon;
import com.microservices.entity.UserEntity;
import com.microservices.enums.RolesEnum;
import com.microservices.repository.UserRepository;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;


@Configuration
@Slf4j
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class ApplicationConfig {
//     @Bean
//     @Transactional(rollbackFor = Exception.class)
//     ApplicationRunner applicationRunner(UserRepository userRepository) {
//         return args -> {
//             Optional<UserEntity> adminUserOpt = userRepository.findByUsername("admin");
//             if (adminUserOpt.isEmpty()) {
//                 HashSet<String> roles = new HashSet<>();
//                 roles.add(RolesEnum.ADMIN.name());
//                 UserEntity adminDefault = UserEntity.builder()
//                         .username("admin")
//                         .password(new BCryptPasswordEncoder(ConstantCommon.STRENGTH_PASSWORD).encode("123123"))
//                         .createdDate(new Date())
//                         // .roles(roles)
//                         .build();
//                 userRepository.save(adminDefault);
//                 log.info("Create account ADMIN default with username: admin, password: 123123, created date: {}", adminDefault.getCreatedDate());
//             }
//         };
//     }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().
                        addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes
                        ("Bearer Authentication", createAPIKeyScheme()))
                .info(new Info().title("Microservice REST API")
                        .description("Microservice description of API.")
                        .version("1.0").contact(new Contact().name("Lê Nhựt Hào")
                                .email( "nhuthaole1908@gmail.com").url("nhuthaole1908@gmail.com"))
                        .license(new License().name("License of API")
                                .url("API license URL")));
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}
