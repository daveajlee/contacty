package de.davelee.misc.contact.rest.controllers;

import de.davelee.misc.contact.data.ContactRequest;
import de.davelee.misc.contact.service.SendEmailService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;

/**
 * This class is a Rest Controller for the Spring Boot Contact Microservice. It defines a single POST endpoint
 * /contact/sendEmail which takes a ContactRequest object as JSON parameter. The Controller uses a SendEmailService to actually send the
 * email!
 * @author Dave Lee
 */
@RestController
@Api(value="/contact")
@SwaggerDefinition(
        tags = {
                @Tag(name = "Contacty - Contact Microservice", description = "Contact operations")
        }
)
@RequestMapping(value="/contact")
public class ContactRestController {

    /**
     * The Access Log is a simple log which stores how many emails (value) have been sent per day (key).
     */
    private final static HashMap<LocalDate, Integer> ACCESS_LOG = new HashMap<>();

    /**
     * The SendEmailService is a small Java service to actually send the email to the definied recipient.
     */
    @Autowired
    private SendEmailService sendEmailService;

    /**
     * This property defines how many requests to send emails can be performed per day. It is a spam prevention feature.
     */
    @Value("${max.num.emails}")
    private int maxAllowedEmails;

    /**
     * Enable logging for this class.
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ContactRestController.class);

    /**
     * This a POST endpoint /sendEmail. It takes a ContactRequest object as JSON in the request body.
     * If using this endpoint from JavaScript or a similar language then you will need to add @CrossOrigin to allow
     * requests from other domains.
     * The endpoint checks how many requests to send emails have been made today. If the number is less than the defined
     * maximum number of requests per day then the request is logged and forwarded to the SendEmailService. If more
     * requests are sent than allowed per day then they will be returned with a 200 response but will not be forwarded
     * to the service and only logged that a request was made. This prevents a spammer detecting that the service is not
     * forwarding his emails. Optionally these requests could be logged in full with name, email address etc. but this is
     * not currently implemented because of data privacy regulations.
     * @param contactRequest a <code>ContactRequest</code> object containing the name, email address, website and message
     *                       from the sender.
     * @return a <code>ResponseEntity</code> object with the status code and no content.
     */
    @ApiOperation(value = "Send information by email", notes="Method to send data per email.")
    @PostMapping(value="/sendEmail")
    @ApiResponses(value = {@ApiResponse(code=200,message="Successfully sent email")})
    public ResponseEntity<Void> sendEmail ( @RequestBody final ContactRequest contactRequest ) {
        //Check how many emails already sent today.
        Integer number = ACCESS_LOG.get(LocalDate.now());
        //If it is null then add 1 and send email.
        if ( number == null ) {
            ACCESS_LOG.put(LocalDate.now(), 1);
            sendEmailService.sendEmail(contactRequest);
        } else {
            //Check if number was less than maximum allowed - as we only send the email in that case.
            if ( number < maxAllowedEmails ) {
                ACCESS_LOG.put(LocalDate.now(), number+1);
                sendEmailService.sendEmail(contactRequest);
            } else {
                //Log excessive requests anonymously.
                LOGGER.warn("Request " + number + " was not processed as maximum number of permitted emails (" +
                        maxAllowedEmails + ")" + " were already processed for today!");
            }
        }
        return ResponseEntity.ok().build();
    }

}