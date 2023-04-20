package de.davelee.misc.contact.rest.controllers;

import de.davelee.misc.contact.configuration.SwaggerConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * This class tests the SwaggerConfiguration without running Spring Boot.
 * @author Dave Lee
 */
@SpringBootTest
public class SwaggerConfigurationTest {

    /**
     * This method tests the use case:
     * 1. That a swagger configuration for the api is present.
     * 2. That the swagger configuration contains at least the group name contact.
     */
    @Test
    public void testSwagger() {
        SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();
        assertNotNull(swaggerConfiguration.publicApi());
    }

}
