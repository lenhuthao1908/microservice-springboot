package com.microserives;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ConfigurationPropertiesScan({"com"})
@ComponentScan(
        basePackages = {"com"}
)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}