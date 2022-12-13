import { formatPhoneNumberIntl } from "react-phone-number-input";

import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";

import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./ApplicationDetails.module.css";

function ApplicationDetails(props) {
  var application = props.application;
  var phoneNumber = formatPhoneNumberIntl(application.phone);
  return (
    <Card >

      <Form className="form">
      <h3 className={classes.heading}>Application</h3>
      <hr />
      <h6>Contact Information</h6>
      <hr className={classes.simple} />
      <Table>
        <tbody>
          <tr>
            <td>Email</td>
            <td>{application.email}</td>
          </tr>
          <tr>
            <td>Address</td>
            <td>{application.address}</td>
          </tr>
          <tr>
            <td>Phone Number</td>
            <td>{phoneNumber}</td>
          </tr>
        </tbody>
      </Table>

      <h6>Erasmus Preferences</h6>
      <hr className={classes.simple} />
        <Form.Group as={Row} className="my-3" controlId="preferredPeriod">
          <Col sm="3">Time Period</Col>
          <Col>
            <Form.Check
              inline
              label="Fal Semester Only"
              name="group1"
              type="checkbox"
              id={`inline-checkbox-1`}
            />
            <Form.Check
              inline
              label="Spring Semester Only"
              name="group1"
              type="checkbox"
              id={`inline-checkbox-2`}
            />
            <Form.Check
              inline
              label="Fal & Spring Semesters"
              type="checkbox"
              id={`inline-checkbox-3`}
            />
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            1st Preference
          </Form.Label>
          <Col>
            <Form.Select aria-label="Gender">
              <option>
                Ecole Polytechnique Federale de Lausanne (EPFL)-Switzerland
              </option>
              <option value="1">Male</option>
              <option value="2">Female</option>
            </Form.Select>
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            2nd Preference
          </Form.Label>
          <Col>
            <Form.Select aria-label="Gender">
              <option>Vrije Universiteit Amsterdam-The Netherlands</option>
              <option value="1">Male</option>
              <option value="2">Female</option>
            </Form.Select>
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            3rd Preference
          </Form.Label>
          <Col>
            <Form.Select aria-label="Gender">
              <option>
                Ecole Pour Linformatique Et Les Techniques Avancees
                (EPITA)-France
              </option>
              <option value="1">Male</option>
              <option value="2">Female</option>
            </Form.Select>
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            4th Preference
          </Form.Label>
          <Col>
            <Form.Select aria-label="Gender">
              <option>Kingston University-U.K.</option>
              <option value="1">Male</option>
              <option value="2">Female</option>
            </Form.Select>
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            5th Preference
          </Form.Label>
          <Col>
            <Form.Select aria-label="Gender">
              <option></option>
              <option value="1">Male</option>
              <option value="2">Female</option>
            </Form.Select>
          </Col>
        </Form.Group>

        <h6>Documents</h6>
        <hr />
        <Form.Group as={Row} controlId="formFile" className="mb-3">
          <Form.Label column sm="3">
            CV
          </Form.Label>
          <Col>
            <Form.Control type="file" />
          </Col>
        </Form.Group>

        <Form.Group as={Row} className="mt-4" controlId="formPlaintextEmail">
          <Col className="text-center">
            <Button variant="primary" className="button-default" type="submit">
              Save Changes
            </Button>
          </Col>
        </Form.Group>
      </Form>
    </Card>
  );
}

export default ApplicationDetails;
