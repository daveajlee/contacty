import {Accordion, Card, Col, Container, Row} from "react-bootstrap";
import roadmapImage from "../assets/jess-bailey-mexeVPlTB6k-unsplash.jpg";

const Roadmap = () => (
    <Container fluid>
        <Row>
            <Col>
                <Card className="border-0">
                    <Card.Img variant="top" className="img-responsive w-25 rounded mx-auto d-block mt-3" src={roadmapImage} />
                    <Card.Title as="h3" className="mt-5 text-center">Roadmap</Card.Title>
                    <Card.Body className="text-center mb-5">This page contains a list of features that I plan to add
                        to Contacty in the future. It is sorted like a product backlog with the features at the top
                        having more chance of being implemented before the features near the bottom. Since I work on
                        Contacty in my free time, I cannot guarantee any deadlines when features will be available.
                        You can also get in touch with me if you would like to help with the development of Contacty
                        so that features can be implemented more quickly!</Card.Body>
                </Card>
            </Col>
        </Row>
        <Row>
            <Col>
                <Accordion defaultActiveKey="0">
                    <Accordion.Item eventKey="1">
                        <Accordion.Header>More Documentation</Accordion.Header>
                        <Accordion.Body>
                            Contacty should have more documentation about how to use the API and HTML templates.
                        </Accordion.Body>
                    </Accordion.Item>
                    <Accordion.Item eventKey="2">
                        <Accordion.Header>Open Source Workflow</Accordion.Header>
                        <Accordion.Body>
                            An Open Source Workflow will ensure that bugs and new features can be easily added and deployed.
                        </Accordion.Body>
                    </Accordion.Item>
                </Accordion>
            </Col>
        </Row>
    </Container>
);

export default Roadmap;
