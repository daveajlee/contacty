# contact-microservice
Microservices per definition implement a single business feature. This microservice enables emails to be sent using Java Mail through a REST API per JSON. Therefore emails can be sent from any programming language through this REST API and microservice. The service supports SSL.

**How to use**

1. To use the microservice you need to specify the user specific configuration parameters in application.properties and application-production.properties.
2. Create an executable jar using mvn clean install.
3. Run the jar (for example in production mode): java -Dspring.profiles.active=production -jar contact-microservice.jar

**Available Profiles**
* dev - This profile sets the Log level to INFO and only allows 2 e-mails (per default) to be sent before the service has to be restarted. This works well for development and testing.
* production - This profile sets the Log Level to WARN, uses SSL per default and allow 100 e-mails per day to be sent.
* test - This profile uses a built-in SMTP Server and is only suitable for JUnit tests.
