package com.microservices;

import com.microservices.common.ConstantCommon;
import com.microservices.entity.AccountEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

@SpringBootApplication
@ConfigurationPropertiesScan({"com.microservices.*"})
@ComponentScan(
        basePackages = {"com.microservices.*"}
)
public class Main extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}