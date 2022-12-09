import { Container } from "react-bootstrap";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Card from "../UI/Card";
import classes from "./ProfileDetails.module.css";
import PhoneInput from "react-phone-input-2";
import "react-phone-input-2/lib/material.css";

function ProfileDetails(props) {
  var profile = props.profile;

  return (
    <Card>
      <Container className={classes.form}>
        <h3 className={classes.heading}>Profile</h3>
        <hr />
        <h5>Personal Information</h5>
        <hr />

        <Form>
          <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
            <Form.Label column sm="3">
              Name
            </Form.Label>
            <Col>
              <Form.Control type="text" defaultValue="email@example.com" />
            </Col>
          </Form.Group>

          <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
            <Form.Label column sm="3">
              Surname
            </Form.Label>
            <Col>
              <Form.Control type="text" defaultValue="email@example.com" />
            </Col>
          </Form.Group>

          <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
            <Form.Label column sm="3">
              Email
            </Form.Label>
            <Col>
              <Form.Control type="text" defaultValue="email@example.com" />
            </Col>
          </Form.Group>

          <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
            <Form.Label column sm="3">
              Date of Birth
            </Form.Label>
            <Col>
              <Form.Control type="date" defaultValue="email@example.com" />
            </Col>
          </Form.Group>

          <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
            <Form.Label column sm="3">
              Phone
            </Form.Label>
            <Col>
              <PhoneInput country={"tr"} />
            </Col>
          </Form.Group>

          <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
            <Form.Label column sm="3">
              National ID
            </Form.Label>
            <Col>
              <Form.Control type="text" defaultValue="email@example.com" />
            </Col>
          </Form.Group>

          <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
            <Form.Label column sm="3">
              Gender
            </Form.Label>
            <Col>
              <Form.Select aria-label="Gender">
                <option>Gender</option>
                <option value="1">Male</option>
                <option value="2">Female</option>
              </Form.Select>
            </Col>
          </Form.Group>

          <Form.Group as={Row} className="mt-4" controlId="formPlaintextEmail">
            <Col className="text-center">
              <Button variant="primary" type="submit">
                Save Changes
              </Button>
            </Col>
          </Form.Group>
        </Form>
        
      </Container>
    </Card>
  );
}

export default ProfileDetails;
