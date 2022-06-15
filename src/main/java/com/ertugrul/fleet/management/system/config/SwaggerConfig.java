package com.ertugrul.fleet.management.system.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.util.StringUtils;


@Configuration
@EnableJpaAuditing
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        final String apiTitle = String.format("%s API", StringUtils.capitalize("Fleet Management System"));
        return new OpenAPI()
                .info(new Info().title(apiTitle).version("1"));
    }
}