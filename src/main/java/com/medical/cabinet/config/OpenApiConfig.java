package com.medical.cabinet.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Mon API")
                        .version("0.0.1")
                        .description("API for a medical cabinet: doctors directory, appointment slots, and reservations.")
                        .contact(
                                new Contact()
                                        .name("Mohamed AGHZER")
                                        .email("mohamed.aghzer01@gmail.com")));
    }
}

