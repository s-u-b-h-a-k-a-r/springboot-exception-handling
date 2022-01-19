package com.subhakar.spring;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SwaggerConfig {
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public OpenAPI customAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(applicationName)
                        .version("1.0")
                        .description("Tutorial on exception handling"));

    }
}
