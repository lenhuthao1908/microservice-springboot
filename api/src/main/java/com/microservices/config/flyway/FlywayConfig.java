package com.microservices.config.flyway;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**s
 * FlywayConfig
 *
 * @version 01-00
 * @since 6/7/2024
 */
@Configuration
@Slf4j
public class FlywayConfig {

    @Value("${spring.flyway.locations}")
    private String[] locationsFlyway;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Bean
    public Flyway flyway() {
        Flyway flyway = Flyway.configure().dataSource(dataSource()).locations(locationsFlyway).load();
        flyway.migrate();
        return flyway;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);
        dataSource.setSchema("public");
        return dataSource;
    }

}
