import {Button, Card, Col, Container, Row} from "react-bootstrap";

const Download = () => (
    <Container fluid>
        <Row>
            <Col>
                <h2 className="mt-5 text-center">Download</h2>
            </Col>
        </Row>
        <Row className="mt-5">
            <Col xs={12} sm={12} md={6} lg={6}>
                <Card className="text-center nav-card">
                    <Card.Body>
                        <Card.Title>Server</Card.Title>
                        <Card.Text>
                            A running server instance is required before the HTML templates for Contacty can be used. This
                            server can be run on any computer which supports Java 11 or above. It can be
                             manually started via the supplied JAR file.
                             <br className="d-none d-lg-block"/><br className="d-none d-lg-block"/>
                        </Card.Text>
                        <Button variant="primary" href="https://github.com/daveajlee/contacty/releases/tag/v1.1.0">JAR</Button>
                    </Card.Body>
                </Card>
            </Col>
            <Col xs={12} sm={12} md={6} lg={6}>
                <Card className="text-center nav-card">
                    <Card.Body>
                        <Card.Title>HTML Templates</Card.Title>
                        <Card.Text>
                            Contacty provides HTML templates for entering message content, when the e-mail is sent successfully 
                            to the recipient, when the e-mail cannot be sent to the recipient or invalid information is provided. 
                            <br className="d-none d-lg-block"/><br className="d-none d-lg-block"/>
                        </Card.Text>
                        <Button variant="primary"
                                href="https://github.com/daveajlee/contacty/tree/main/src/main/resources/templates">HTML Templates</Button>
                    </Card.Body>
                </Card>
            </Col>
        </Row>
    </Container>
);

export default Download;
