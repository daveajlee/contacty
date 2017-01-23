package de.davelee.misc.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

/**
 * This class represents the Spring Boot Application for the Contact Microservice.
 * @author Dave Lee
 */
@SpringBootApplication
@ComponentScan({"de.davelee.misc.contact.configuration","de.davelee.misc.contact.rest.controllers","de.davelee.misc.contact.service"})
public class ContactMicroserviceApplication {

    public static void main ( String[] args ) {
        SpringApplication.run(ContactMicroserviceApplication.class, args);
    }

}