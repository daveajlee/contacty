# contact-microservice

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/c6966f0291de4fada794ac4d7b32dedf)](https://app.codacy.com/manual/dave_33/contact-microservice?utm_source=github.com&utm_medium=referral&utm_content=daveajlee/contact-microservice&utm_campaign=Badge_Grade_Dashboard)

Microservices per definition implement a single business feature. This microservice enables emails to be sent using Java Mail through a REST API per JSON. Therefore emails can be sent from any programming language through this REST API and microservice. The service supports SSL.

**How to use**

1.  To use the microservice you need to specify the user specific configuration parameters in application.properties and application-production.properties.
2.  Create an executable jar using mvn clean install.
3.  Run the jar (for example in production mode): java -Dspring.profiles.active=production -jar contact-microservice.jar

**How to integrate the contact microservice with your website**
*    Option 1: The contact microservice comes with a small simple HTML form which can be directly integrated into your website. This form is available by calling the contact microservice with the URL https://your-domain/contact-microservice/
*    Option 2: You can integrate the contact microservice using JavaScript. A simple JavaScript for the contact microservice would look like this

var contactRequest = {};
contactRequest.name = document.forms[0][0].value;
contactRequest.emailAddress = document.forms[0][1].value;
contactRequest.website = document.forms[0][2].value;
contactRequest.message = document.forms[0][3].value;
$.ajax({
     url: "https://your-domain/contact-microservice/sendEmail",
     method: "POST",
     contentType: "application/json",
     data: JSON.stringify(contactRequest)
});

*  You can also test the contact microservice using the Swagger Interface located at https://your-domain/contact-microservice/swagger-ui.html

**Available Profiles**
*    dev - This profile sets the Log level to INFO and only allows 2 e-mails (per default) to be sent before the service has to be restarted. This works well for development and testing.
*    production - This profile sets the Log Level to WARN, uses SSL per default and allow 100 e-mails per day to be sent.
*    test - This profile uses a built-in SMTP Server and is only suitable for JUnit tests.
