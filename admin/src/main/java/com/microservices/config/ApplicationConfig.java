package com.microservices.config;

import com.microservices.common.ConstantCommon;
import com.microservices.entity.AccountEntity;
import com.microservices.repository.AccountRepository;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Date;
import java.util.Objects;

@Configuration
@Slf4j
@EnableTransactionManagement
public class ApplicationConfig {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> transactionTemplate.execute(status -> {
            AccountEntity adminUserOpt = accountRepository.getAccountByUsername("admin");
            if (Objects.isNull(adminUserOpt)) {
                AccountEntity adminDefault = new AccountEntity();
                adminDefault.setUsername("admin");
                adminDefault.setPassword(new BCryptPasswordEncoder(ConstantCommon.STRENGTH_PASSWORD).encode("123123"));
                adminDefault.setCreatedDate(new Date());
                accountRepository.create(adminDefault);
                log.info("Create account ADMIN default with username: admin, password: 123123, created date: {}", adminDefault.getCreatedDate());
            }
            return null;
        });
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement()
                        .addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes(
                        "Bearer Authentication", createAPIKeyScheme()))
                .info(new Info().title("Microservice REST API")
                        .description("Microservice description of API.")
                        .version("1.0")
                        .contact(new Contact().name("Lê Nhựt Hào")
                                .email("nhuthaole1908@gmail.com")
                                .url("nhuthaole1908@gmail.com"))
                        .license(new License().name("License of API")
                                .url("API license URL")));
    }

    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}
