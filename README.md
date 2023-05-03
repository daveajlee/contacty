<p align="center">
<img src="https://www.davelee.de/common/assets/img/portfolio/contacty-logo.png" alt="Contacty" width="300" height="300">
</p>

<p align=center><a href="https://app.codacy.com/manual/dave_33/contact-microservice?utm_source=github.com&utm_medium=referral&utm_content=daveajlee/contact-microservice&utm_campaign=Badge_Grade_Dashboard"><img src="https://api.codacy.com/project/badge/Grade/c6966f0291de4fada794ac4d7b32dedf" alt="Codacy Badge"> </a>
</p>

Contacty is a open source plug-in to send feedback or other data to a defined recipient. It enables the data to sent from any programming language through a REST API and Microservice thereby enabling other programming languages which do not directly support sending such data to do so.

## How to get started with Contacty

1.  To use Contacty you need to specify the user specific configuration parameters in application.properties and application-production.properties.
2.  Create an executable jar using `mvn clean install`.
3.  Run the jar (for example in production mode) with at least Java 11: `java -Dspring.profiles.active=production -jar contacty.jar`

## How to integrate Contacty with your website
*    Option 1: Contacty comes with a small simple HTML form which can be directly integrated into your website. This form is available by calling Contacty with the URL https://your-domain/contacty/
*    Option 2: You can integrate Contacty using JavaScript. A simple JavaScript for the contact microservice would look like this

`var contactRequest = {};
contactRequest.name = document.forms[0][0].value;
contactRequest.emailAddress = document.forms[0][1].value;
contactRequest.website = document.forms[0][2].value;
contactRequest.message = document.forms[0][3].value;
$.ajax({
     url: "https://your-domain/contacty/sendEmail",
     method: "POST",
     contentType: "application/json",
     data: JSON.stringify(contactRequest)
});`

*  You can also test Contacty using the Swagger Interface located at https://your-domain/contacty/swagger-ui.html

## Available Profiles for Contacty
*    dev - This profile sets the Log level to INFO and only allows 2 e-mails (per default) to be sent before the service has to be restarted. This works well for development and testing.
*    production - This profile sets the Log Level to WARN, uses SSL per default and allow 100 e-mails per day to be sent.
*    test - This profile uses a built-in SMTP Server and is only suitable for JUnit tests.
