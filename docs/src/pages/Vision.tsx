import {Accordion, Card, Col, Container, Row} from "react-bootstrap";
import visionImage from "../assets/joshua-earle-Dwheufds6kQ-unsplash.jpg";

const Vision = () => (
    <Container fluid>
        <Row>
            <Col>
                <Card className="border-0">
                    <Card.Img variant="top" className="img-responsive w-25 rounded mx-auto d-block mt-3" src={visionImage} />
                    <Card.Title as="h3" className="mt-5 text-center">Contacty Vision</Card.Title>
                    <Card.Body className="text-center mb-5">Contacty simplifies the process of sending feedback or other messages to a defined recipient.</Card.Body>
                </Card>
            </Col>
        </Row>
        <Row>
            <Col>
                <h3 className="mt-5 text-center">Goals</h3>
                <Accordion className="mt-3">
                    <Accordion.Item eventKey="0">
                        <Accordion.Header>Open Source</Accordion.Header>
                        <Accordion.Body>
                            Contacty should be an open source plug-in which is capable of sending feedback or other messages to a defined recipient.
                        </Accordion.Body>
                    </Accordion.Item>
                    <Accordion.Item eventKey="1">
                        <Accordion.Header>Independent of Programming Language</Accordion.Header>
                        <Accordion.Body>
                            Contacty should be capable of being used with any programming language and therefore
                            have an appropriate API and documentation to allow developers to integrate Contacty into their applications regardless of the programming language they are using.
                        </Accordion.Body>
                    </Accordion.Item>
                    <Accordion.Item eventKey="2">
                        <Accordion.Header>Easy Deployment</Accordion.Header>
                        <Accordion.Body>
                            Contacty should be capable of being deployed easily to any infrastructure setting.
                        </Accordion.Body>
                    </Accordion.Item>
                </Accordion>
            </Col>
        </Row>
    </Container>
);

export default Vision;
