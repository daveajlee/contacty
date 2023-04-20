package de.davelee.misc.contact.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * This class configures swagger to ensure the correct api endpoints and information is shown.
 * @author Dave Lee
 */
@Configuration
@Profile("test")
public class SwaggerConfiguration {

    @Bean
    public OpenAPI contactyOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Contacty API")
                        .description("Microservices per definition implement a single business feature. This microservice enables emails to be sent using Java Mail through a REST API per JSON. Therefore emails can be sent from any programming language through this REST API and microservice.")
                        .version("v1.2.0")
                        .license(new License().name("Apache 2.0").url("https://www.davelee.de")))
                .externalDocs(new ExternalDocumentation()
                        .description("Contacty Documentation")
                        .url("https://www.davelee.de/"));
    }

    /**
     * This method returns a GroupedOpenApi object containing the api information and endpoints.
     * @return a <code>GroupedOpenApi</code> object containing the api information and endpoints.
     */
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("contacty")
                .pathsToMatch("/contact/**")
                .build();
    }

}
