import {Accordion, Card, Col, Container, Row} from "react-bootstrap";
import roadmapImage from "../assets/jess-bailey-mexeVPlTB6k-unsplash.jpg";

const Features = () => (
    <Container fluid>
        <Row>
            <Col>
                <Card className="border-0">
                    <Card.Img variant="top" className="img-responsive w-25 rounded mx-auto d-block mt-3" src={roadmapImage} />
                    <Card.Title as="h3" className="mt-5 text-center">Features</Card.Title>
                    <Card.Body className="text-center mb-5">This page contains information about features that are already
                    implemented in Contacty. <br/> Please visit the Roadmap page if you would like to find out more
                    about new features that are planned.</Card.Body>
                </Card>
            </Col>
        </Row>
        <Row>
            <Col>
                <Accordion defaultActiveKey="0">
                    <Accordion.Item eventKey="0">
                        <Accordion.Header>Send Messages to Recipients</Accordion.Header>
                        <Accordion.Body>
                            As a Contacty user, I can send a message to a recipient with a name and e-mail address. Optionally, the message can also contain a url to a web site.
                        </Accordion.Body>
                    </Accordion.Item>
                    <Accordion.Item eventKey="1">
                        <Accordion.Header>Limit Number of Emails per day</Accordion.Header>
                        <Accordion.Body>
                            As a Contacty administrator, I can set the maximum number of emails which can be sent per day. This prevents Contacty being misused for spam purposes.
                        </Accordion.Body>
                    </Accordion.Item>
                    <Accordion.Item eventKey="2">
                        <Accordion.Header>HTML Templates</Accordion.Header>
                        <Accordion.Body>
                            Contacty provides an HTML template for the user to enter the message content and the information about the recipient.
                            In addition, there is a HTML template when the e-mail is sent successfully to the recipient.
                            There is also an HTML template when the e-mail cannot be sent to the recipient or
                            invalid information is provided such as an e-mail address without the @ symbol.
                        </Accordion.Body>
                    </Accordion.Item>
                    <Accordion.Item eventKey="3">
                        <Accordion.Header>REST API</Accordion.Header>
                        <Accordion.Body>
                            Contacty provides a REST API endpoint to send an e-mail. The body of the request contains the message and recipient information.
                            An appropriate status code is returned as a response. More information about the API can be found on the API page.
                        </Accordion.Body>
                    </Accordion.Item>
                </Accordion>
            </Col>
        </Row>
    </Container>
);

export default Features;
