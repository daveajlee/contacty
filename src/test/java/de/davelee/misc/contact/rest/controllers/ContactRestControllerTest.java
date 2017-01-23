package de.davelee.misc.contact.rest.controllers;

import com.jayway.restassured.RestAssured;
import de.davelee.misc.contact.data.ContactRequest;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.jayway.restassured.RestAssured.given;

/**
 * This class tests the ContactRestController and indirectly the SendEmailService.
 * @author Dave Lee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactRestControllerTest {

    /**
     * This is the port where the test server will run - it is randomly chosen by Spring Test.
     */
    @Value("${local.server.port}")
    int port;

    /**
     * Initalise the port for the Spring Boot Test application.
     */
    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    /**
     * This method tests the following use cases:
     * 1. Sends a test email.
     * 2. Sends enough test emails so that the maximum number of emails permitted in the dev-test profile are exceeded.
     */
    @Test
    public void testHelloWorld() {
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setEmailAddress("test@davelee.de");
        contactRequest.setMessage("Test Message");
        contactRequest.setName("JUnit Test");
        contactRequest.setWebsite("www.localhost.org");
        given()
                .contentType("application/json")
                .body(contactRequest)
                .when()
                .post("/contact/sendEmail")
                .then()
                .statusCode(HttpStatus.SC_OK);
        given()
                .contentType("application/json")
                .body(contactRequest)
                .when()
                .post("/contact/sendEmail")
                .then()
                .statusCode(HttpStatus.SC_OK);
        given()
                .contentType("application/json")
                .body(contactRequest)
                .when()
                .post("/contact/sendEmail")
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

}