import {Accordion, Col, Container, Row} from "react-bootstrap";
import architectureFigure from "../assets/architecture.png";
import architectureSmall from "../assets/architecture-mobile.png";
import MediaQuery from 'react-responsive';

const Architecture = () => (
    <Container fluid>
        <Row>
            <Col>
                <h2 className="mt-5 text-center">Architecture</h2>
                <MediaQuery query="(max-device-width: 900px)">
                    <Col className="text-center mt-5"><img src={architectureSmall} alt="PersonalMan"
                                                           className="img-responsive"/></Col>
                </MediaQuery>
                <MediaQuery query="(min-device-width: 901px)">
                    <Col className="text-center mt-5"><img src={architectureFigure} alt="PersonalMan"
                                                           className="img-responsive"/></Col>
                </MediaQuery>
            </Col>
        </Row>
        <Row>
            <Col>
                <p className="mt-5">The current architecture of Contacty is based on the classical client server architecture
                pattern. This pattern ensures a separation of concern between the client and the server. The client can focus
                on presenting the data effectively to the user and providing options of what the user may want to do next
                and the server can concentrate on processing the requests that the user has made and providing answers
                to the client. The communication between the client and server is managed through an API. In addition,
                Contacty requires an SMTP Server to actually send the messages via the internet. A description
                of each part of the architecture diagram follows in the next section.</p>
            </Col>
        </Row>
        <Row>
            <Col>
                <Accordion defaultActiveKey="0">
                    <Accordion.Item eventKey="0">
                        <Accordion.Header>Client (HTML Templates)</Accordion.Header>
                        <Accordion.Body>
                            The current architecture of Contacty enables the user to freely design HTML templates which can then
                            call the API endpoint to send messages. Theoretically, it would be possible to build
                            a desktop client or a mobile app which uses the Contacty API but this is not currently planned.
                            Sample HTML templates are provided in the download section of this website. 
                        </Accordion.Body>
                    </Accordion.Item>
                    <Accordion.Item eventKey="1">
                        <Accordion.Header>Server (Contacty API)</Accordion.Header>
                        <Accordion.Body>
                            The server component is stateless and implements a REST API with a single endpoint to send a message.
                            This ensures a simple and easy-to-use API which clients can then implement. The Server
                            component is currently built in Java using Spring Boot. The server component can optionally
                            also be deployed via Docker container(s). Communication with the client can be either via HTTP or HTTPS but HTTPS is recommended for security reasons.
                        </Accordion.Body>
                    </Accordion.Item>
                    <Accordion.Item eventKey="3">
                        <Accordion.Header>SMTP Server</Accordion.Header>
                        <Accordion.Body>
                            Contacty requires an SMTP Server to actually send the messages via the internet. The SMTP Server
                            is responsible for handling the email transmission and ensuring that messages are delivered
                            to the intended recipients. Contacty can be configured to work with any SMTP Server.
                        </Accordion.Body>
                    </Accordion.Item>
                </Accordion>
            </Col>
        </Row>
    </Container>
);

export default Architecture;
