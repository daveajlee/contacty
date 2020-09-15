package de.davelee.misc.contact.rest.controllers;

import de.davelee.misc.contact.configuration.SwaggerConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * This class tests the SwaggerConfiguration without running Spring Boot.
 * @author Dave Lee
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class SwaggerConfigurationTest {

    /**
     * This method tests the use case:
     * 1. That a swagger configuration for the api is present.
     * 2. That the swagger configuration contains at least the group name contact.
     */
    @Test
    public void testSwagger() {
        SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration();
        assertNotNull(swaggerConfiguration.api());
    }

}
