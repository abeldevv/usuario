package com.abeldevv.usuario.config;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
            .group("restful-api-v1.0")
            .pathsToMatch("/**")
            .addOpenApiCustomizer(openApi -> openApi.info(new Info()
                .title("API RESTFUL")
                .description("Esta api esta desarrollado para uso personal."
                		+ "   Este proyecto consistirá en el Desarrollo de  "
                		+ "   una API RESTful utilizando Spring Boot para realizar operaciones CRUD "
                		+ "	  (Crear, Leer, Actualizar, Eliminar) en una base de datos."
                		+ "   Crear endpoints para diferentes entidades y operaciones,"
                		+ "   como usuarios, productos, pedidos.")
                .version("v2.0")))
            .build();
    }
}
