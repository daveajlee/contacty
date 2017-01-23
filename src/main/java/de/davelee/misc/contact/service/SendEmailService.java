package de.davelee.misc.contact.service;

import de.davelee.misc.contact.data.ContactRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * This service sends emails received from the ContactRestController to the defined recipient address with the defined
 * subject. The email will appear as if it was sent from the defined from address which enables better filtering by
 * email clients.
 * @author Dave Lee
 */
@Service
public class SendEmailService {

    /**
     * The SendEmailService uses the JavaMailSender of the Spring Framework to send emails.
     */
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * This property sets the sender's address based on the value in application.properties. (This will be different
     * from the email address supplied in the original contact request to enable better mail filtering)
     */
    @Value("${email.from}")
    private String fromAddress;

    /**
     * This property sets the recipient's address based on the value in application.properties.
     */
    @Value("${email.to}")
    private String toAddress;

    /**
     * This property sets the subject for the e-mail based on the value in application.properties.
     */
    @Value("${email.subject}")
    private String subject;

    /**
     * This property sets the subject for the e-mail based on the value in application.properties.
     */
    @Value("${email.message}")
    private String message;

    /**
     * Enable logging for this class.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(SendEmailService.class);

    /**
     * Send an email using the supplied <code>ContactRequest</code> object which contains name, email address, website
     * and message as the content of the email. Attempts to send emails will be logged.
     * @param contactRequest a <code>ContactRequest</code> object containing the content of the email.
     */
    public void sendEmail ( final ContactRequest contactRequest ) {
        LOGGER.info("Sending email!");
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(toAddress);
        mail.setFrom(fromAddress);
        mail.setSubject(subject);
        mail.setText(MessageFormat.format(message, contactRequest.getName(), contactRequest.getEmailAddress(),
                contactRequest.getWebsite(), contactRequest.getMessage()));
        javaMailSender.send(mail);
        LOGGER.info("Sent e-mail");
    }

}
