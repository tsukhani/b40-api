package com.pinelabs.b40api.configurations;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info().title("B40Locator-API")
                .description("We care about B40 :)");
        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}

