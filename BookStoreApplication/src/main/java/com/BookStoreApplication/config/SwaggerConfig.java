package com.BookStoreApplication.config;


import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI bookstoreAPI() {
        return new OpenAPI().info(new Info()
                .title("Bookstore API")
                .description("REST API for managing books and authors")
                .version("1.0"));
    }
}