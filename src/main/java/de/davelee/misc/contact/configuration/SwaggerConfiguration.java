package de.davelee.misc.contact.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * This class configures the swagger documentation.
 */
@Configuration
@Profile("dev-test")
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("contact")
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .paths(or (regex("/contact.*")))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Contact Microservice API")
                .description("Rest API for Sending Emails")
                .termsOfServiceUrl("http://www.davelee.de")
                .contact("Dave Lee")
                .license("License Info")
                .licenseUrl("http://www.davelee.de")
                .version("1.0")
                .build();
    }

}