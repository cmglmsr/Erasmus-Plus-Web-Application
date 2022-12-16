import { formatPhoneNumberIntl } from "react-phone-number-input";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./ApplicationForm.module.css";
import { useNavigate} from 'react-router-dom';

const timePeriod = {
  1: "Fall Semester",
  2: "Spring Semester",
  3: "Fall & Spring Semester",
};
const ApplicationDetails = ({
  mail,
  address,
  phoneNumber,
  term,
  first,
  second,
  third,
  fourth,
  fifth,
  status,
  cv,
}) => {
  var phoneNumberFormatted = formatPhoneNumberIntl("+" + phoneNumber);
  const navigate = useNavigate();

  function onDelete() {
    fetch("http://localhost:8080/student/deleteApplication", {
      method: "GET",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
        Cookie: document.cookie,
      },
    }).then((response) => {
      if (response.status === 200) {
        window.confirm("Application Deleted");
        navigate('/student/home');
      }
    });
  }
  return (
    <Card>
      <Form className="form">
        <h3 className={classes.heading}>Application</h3>
        <hr />
        <h6>Contact Information</h6>
        <hr className={classes.simple} />
        <Table>
          <tbody>
            <tr>
              <td>Email</td>
              <td>{mail}</td>
            </tr>
            <tr>
              <td>Address</td>
              <td>{address}</td>
            </tr>
            <tr>
              <td>Phone Number</td>
              <td>{phoneNumberFormatted}</td>
            </tr>
          </tbody>
        </Table>
        <h6>Status</h6>
        <hr className={classes.simple} />
        <Table>
          <tbody>
            <tr>
              <td>Status</td>
              <td>{status}</td>
            </tr>
          </tbody>
        </Table>
        <h6>Erasmus Preferences</h6>
        <hr className={classes.simple} />
        <Table>
          <tbody>
            <tr>
              <td>Time Period</td>
              <td>{timePeriod[term]}</td>
            </tr>
            <tr>
              <td>1st Preference</td>
              <td>{first}</td>
            </tr>
            <tr>
              <td>2nd Preference</td>
              <td>{second}</td>
            </tr>
            <tr>
              <td>3rd Preference</td>
              <td>{third}</td>
            </tr>
            <tr>
              <td>4th Preference</td>
              <td>{fourth}</td>
            </tr>
            <tr>
              <td>5th Preference</td>
              <td>{fifth}</td>
            </tr>
          </tbody>
        </Table>
        <Form.Group as={Row} className="mt-4" controlId="formPlaintextEmail">
          <Col className="text-center">
            <Button
              variant="primary"
              className="button-default mx-3"
              href="/student/manageApplication"
            >
              Manage Application
            </Button>
            <Button
              variant="primary"
              className="btn-danger mx-3"
              onClick={onDelete}
            >
              Delete Application
            </Button>
          </Col>
        </Form.Group>
      </Form>
    </Card>
  );
};
export default ApplicationDetails;
