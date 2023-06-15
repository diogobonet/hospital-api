package com.hospital.hospitalapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Contact contact = new Contact();
        contact.setUrl("https://github.com/brenors/hospital-api");

        Info info = new Info()
                .title("hospital-api")
                .version("1.0")
                .contact(contact)
                .description("API para gerenciamento hospitalar: procedimentos e pessoas(funcionários e pacientes).");

        return new OpenAPI().info(info);
    }
}