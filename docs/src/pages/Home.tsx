import logo from "../assets/contacty-logo.png";
import visionImage from "../assets/joshua-earle-Dwheufds6kQ-unsplash.jpg";
import roadmapImage from "../assets/jess-bailey-mexeVPlTB6k-unsplash.jpg";
import architectureImage from "../assets/arpad-czapp-wS250FJl5Uw-unsplash.jpg";
import apiImage from "../assets/douglas-lopes-ehyV_XOZ4iA-unsplash.jpg";
import {Button, Card, Col, Container, Row} from "react-bootstrap";

function Home() {
    return (
    <Container fluid>
        <Row>
            <Col className="text-center"><img src={logo} alt="PersonalMan"
                      className="img-responsive"/></Col>
        </Row>
        <Row>
            <Col className="text-center mt-5"><h1>Contacty - Making giving Feedback easier!</h1></Col>
        </Row>
        <Row>
            <Col className="text-left mt-3"><p>Contacty is a simple open source plug-in which can be used for websites. 
                The software provides an API as well as a sample template to use for integration. 
                This website provides information about the vision of Contacty as well the opportunity to integrate into other systems through the flexible client server API architecture.</p></Col>
        </Row>
        <Row>
            <Col className="text-left mt-3"><p>If you simply want to try out Contacty without reading the complete documentation first
                (not recommended) then you can simply download the latest version: </p><p className="text-center mt-2"><Button type="button" variant="primary" href="#/download">Download</Button></p></Col>
        </Row>
        <hr/>
        <Row className="mt-3">
            <Col xs={12} sm={12} md={6} lg={3}>
                <Card className="text-center nav-card">
                    <Card.Img variant="top" src={visionImage} alt={"Person sitting on mountain and viewing clouds"}/>
                    <Card.Body>
                        <Card.Title>Vision</Card.Title>
                        <Card.Text>
                            Find out more about the vision and goals behind Contacty.
                        </Card.Text>
                        <Button type="button" variant="primary" href="#/vision">Vision</Button>
                    </Card.Body>
                </Card>
            </Col>
            <Col xs={12} sm={12} md={6} lg={3}>
                <Card className="text-center nav-card">
                    <Card.Img variant="top" src={roadmapImage} alt={"Photo of a diary and pen"}/>
                    <Card.Body>
                        <Card.Title>Features & Roadmap</Card.Title>
                        <Card.Text>
                            Current features and the next features that are planned.
                        </Card.Text>
                        <Button type="button" variant="primary" href="#/features">Features</Button>
                        <Button type="button" variant="primary" className="ms-3" href="#/roadmap">Roadmap</Button>
                    </Card.Body>
                </Card>
            </Col>
            <Col xs={12} sm={12} md={6} lg={3}>
                <Card className="text-center nav-card">
                    <Card.Img variant="top" src={architectureImage} alt={"Photo of a mobile phone and a big screen"} />
                    <Card.Body>
                        <Card.Title>Architecture</Card.Title>
                        <Card.Text>
                            Documentation of the architecture design of Contacty.
                        </Card.Text>
                        <Button type="button" variant="primary" href="#/architecture">Architecture</Button>
                    </Card.Body>
                </Card>
            </Col>
            <Col xs={12} sm={12} md={6} lg={3}>
                <Card className="text-center nav-card">
                    <Card.Img variant="top" src={apiImage} alt={"Photo of a laptop with an API client visible on the main screen"} />
                    <Card.Body>
                        <Card.Title>API</Card.Title>
                        <Card.Text>
                            Technical documentation for developers.
                        </Card.Text>
                        <Button type="button" variant="primary" href="#/api">API</Button>
                    </Card.Body>
                </Card>
            </Col>
        </Row>
    </Container>
    );
};

export default Home;
