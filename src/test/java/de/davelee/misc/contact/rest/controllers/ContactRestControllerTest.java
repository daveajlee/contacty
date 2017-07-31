package de.davelee.misc.contact.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.davelee.misc.contact.data.ContactRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.subethamail.wiser.Wiser;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This class tests the ContactRestController and indirectly the SendEmailService.
 * It uses an built-in SMTP Server von wiser.
 * @author Dave Lee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("test")
public class ContactRestControllerTest {

    private Wiser wiser;

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    private static final Logger logger = LoggerFactory.getLogger(ContactRestControllerTest.class);

    /**
     * Set up the built-in SMTP Server on port 1025 and configure the mock application context.
     */
    @Before
    public void setUp() {
        wiser = new Wiser();
        wiser.setPort(1025);
        wiser.start();
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    /**
     * Before ending the test, stop the built-in SMTP Server.
     * @throws Exception a <code>Exception</code> object which occurs if the SMTP server cannot be stopped.
     */
    @After
    public void tearDown() throws Exception {
        wiser.stop();
    }

    /**
     * This method tests the use case:
     * 1. Send a test email.
     */
    @Test
    public void testSendEmail() {
        ContactRequest contactRequest = new ContactRequest();
        contactRequest.setEmailAddress("test@davelee.de");
        contactRequest.setMessage("Test Message");
        contactRequest.setName("JUnit Test");
        contactRequest.setWebsite("www.localhost.org");
        try {
            mockMvc.perform(post("/contact/sendEmail").contentType(MediaType.APPLICATION_JSON).content(asJsonString(contactRequest))).andExpect(status().isOk());
        } catch (Exception exception) {
            logger.error("An exception occurred whilst attempting to send email", exception);
        }
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

}