import {Card, Col, Container, Row} from "react-bootstrap";
import apiImage from "../assets/douglas-lopes-ehyV_XOZ4iA-unsplash.jpg";

const Api = () => (
    <Container fluid>
        <Row>
            <Col>
                <Card className="border-0">
                    <Card.Img variant="top" className="img-responsive w-25 rounded mx-auto d-block mt-3" src={apiImage} />
                    <Card.Title as="h3" className="mt-5 text-center">API</Card.Title>
                    <Card.Body className="text-center mb-5">The current API of Contacty can be accessed
                        by running Contacty and then the following URL: <br/><br/><span style={{fontWeight: "bold"}}>http://server:port/swagger-ui/index.html</span> <br/><br/>If you would like to test the API or test a
                    client you have built for the API then you need to download Contacty from the Download
                    page.</Card.Body>
                </Card>
            </Col>
        </Row>
        {/*<Row>
            <SwaggerUI url="swagger.json" />
        </Row>*/}
    </Container>
);

export default Api;
