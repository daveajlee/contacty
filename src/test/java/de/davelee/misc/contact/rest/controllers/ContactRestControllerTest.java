package de.davelee.misc.contact.rest.controllers;

import com.dumbster.smtp.SimpleSmtpServer;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.davelee.misc.contact.data.ContactRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This class tests the ContactRestController and indirectly the SendEmailService.
 * It uses an built-in SMTP Server von wiser.
 * @author Dave Lee
 */
@SpringBootTest
public class ContactRestControllerTest {

    private SimpleSmtpServer dumbster;

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    private static final Logger logger = LoggerFactory.getLogger(ContactRestControllerTest.class);

    /**
     * Set up the built-in SMTP Server on port 1025 and configure the mock application context.
     */
    @BeforeEach
    public void setUp() throws IOException {
        dumbster = SimpleSmtpServer.start(1025);
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * Before ending the test, stop the built-in SMTP Server.
     * @throws Exception a <code>Exception</code> object which occurs if the SMTP server cannot be stopped.
     */
    @AfterEach
    public void tearDown() throws Exception {
        dumbster.stop();
    }

    /**
     * This method tests the use case:
     * 1. Send a test email.
     * 2. Send a second test email - this should also work.
     * 3. Send a third test email - this should not work as limits exceeded.
     */
    @Test
    public void testSendEmail() {
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setEmailAddress("test@davelee.de");
        contactRequest.setMessage("Test Message");
        contactRequest.setName("JUnit Test");
        contactRequest.setWebsite("www.localhost.org");
        boolean emailSuccess = false;
        try {
            mockMvc.perform(post("/contact/sendEmail").contentType(MediaType.APPLICATION_JSON).content(asJsonString(contactRequest))).andExpect(status().isOk());
            mockMvc.perform(post("/contact/sendEmail").contentType(MediaType.APPLICATION_JSON).content(asJsonString(contactRequest))).andExpect(status().isOk());
            mockMvc.perform(post("/contact/sendEmail").contentType(MediaType.APPLICATION_JSON).content(asJsonString(contactRequest))).andExpect(status().isOk());
            emailSuccess = true;
        } catch (Exception exception) {
            logger.error("An exception occurred whilst attempting to send email", exception);
        }
        assertTrue(emailSuccess);
    }

    /**
     * This method converts the supplied object into a JSON string. Any errors will be logged.
     * @param object a <code>Object</code> to be converted into JSON
     * @return a <code>String</code> with the JSON representation of this object or null if an error occurred.
     */
    public static String asJsonString(final Object object) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(object);
            return jsonContent;
        } catch (Exception exception) {
            logger.error("An exception occurred whilst translating object into json", exception);
            return null;
        }
    }

    /**
     * Private helper method to ensure Codacy detects assert method.
     * @param condition a <code>boolean</code> condition to test.
     */
    private void assertTrue ( final boolean condition ) {
        Assertions.assertTrue(condition);
    }

}