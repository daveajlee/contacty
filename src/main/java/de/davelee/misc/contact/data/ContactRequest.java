package de.davelee.misc.contact.data;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This class represents a request to make contact through the microservice. A request contains a name, email address,
 * website and message. All parameters are optional. The person making the contact request is referred to as the sender.
 * @author Dave Lee
 */
public class ContactRequest {

    /**
     * The name of the sender (must not be null or empty)
     */
    @NotNull
    @Size(min=1)
    private String name;
    /**
     * The email address of the sender (must not be null or empty).
     */
    @NotNull
    @Size(min=1)
    @Email
    private String emailAddress;
    /**
     * The website of the sender.
     */
    @URL
    private String website;
    /**
     * The message which the sender wrote for the recipient (must not be null or empty).
     */
    @NotNull
    @Size(min=1)
    private String message;

    /**
     * Retrieve the name of the sender of this contact request.
     * @return a <code>String</code> with the name of the sender.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the sender of this contact request.
     * @param name a <code>String</code> with the new name of the sender.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieve the email address of the sender of this contact request.
     * @return a <code>String</code> with the email address of the sender.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set the email address of the sender of this contact request.
     * @param emailAddress a <code>String</code> with the new email address of the sender.
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Retrieve the website of the sender of this contact request.
     * @return a <code>String</code> with the website of the sender of this contact request.
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Set the website of the sender of this contact request.
     * @param website a <code>String</code> with the new website of the sender of this contact request.
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * Retrieve the message that the sender wrote for the recipient of this contact request.
     * @return a <code>String</code> with the message that the sender wrote for the recipient of this contact request.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set a new message for the recipient of this contact request.
     * @param message a <code>String</code> with the new message for the recipient of this contact request.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Return a toString representation of this ContactRequest object containing name, email address, website
     * and message.
     * @return a <code>String</code> containing the String representation of this ContactRequest object.
     */
    public String toString() {
        return "ContactRequest(Name: " + this.name + ", EmailAddress: " + this.emailAddress + ", Website: " +
                this.website + ", Message: " + this.message + ")";
    }

}