package de.davelee.misc.contact.rest.controllers;

import de.davelee.misc.contact.data.ContactRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
/**
 * This class is a UI Controller for the Spring Boot Contact Microservice. It defines the endpoints for
 * the HTML pages which are generated using Thymeleaf and also sends the data to the rest controller
 * for further processing.
 * @author Dave Lee
 */
public class ContactUIController {

    @Autowired
    private ContactRestController contactRestController;

    @GetMapping("/")
    /**
     * Endpoint for showing the form (HTML template: contact.html). A contactRequest object may be supplied
     * if displaying the form to the user after validation.
     * @param contactRequest a <code>ContactRequest</code> object which may be supplied after validation.
     * @return a <code>String</code> with the name of the html template to display.
     */
    public String showForm(ContactRequest contactRequest) {
        return "contact";
    }

    @PostMapping("/")
    /**
     * Endpoint for checking if the supplied contact request data from the form is valid. Return the HTML
     * template (contact.html) if the validation was not sucessful, the HTML template (success.html) if the
     * message could be sent successfully or the HTML template (failed.html) if the message could not be
     * sent successfully.
     * @param contactRequest a <code>ContactRequest</code> object which contains the form data to valid.
     * @param bindingResult a <code>BindingResult</code> object from Spring with the results of the validation.
     * @return a <code>String</code> with the name of the html template to display.
     */
    public String checkContactRequest(@Valid ContactRequest contactRequest, BindingResult bindingResult) {

        //Form had errors i.e. validation was not successful.
        if (bindingResult.hasErrors()) {
            return "contact";
        }

        //Send email from microservice. 200 status code indicates success.
        ResponseEntity<Void> result = contactRestController.sendEmail(contactRequest);
        if ( result.getStatusCode().is2xxSuccessful() ) {
            return "redirect:/success";
        }
        else {
            return "redirect:/failed";
        }

    }

    @GetMapping("/success")
    /**
     * Endpoint for showing the success page (HTML template: success.html).
     * @return a <code>String</code> with the name of the html template to display.
     */
    public String showSuccess() {
        return "success";
    }

    @GetMapping("/failed")
    /**
     * Endpoint for showing the failed page (HTML template: failed.html).
     * @return a <code>String</code> with the name of the html template to display.
     */
    public String showFailed() {
        return "failed";
    }

}
