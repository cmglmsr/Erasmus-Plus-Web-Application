import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Card from "../UI/Card";
import classes from "./ProfileDetails.module.css";
import PhoneInput from "react-phone-input-2";
import "react-phone-input-2/lib/material.css";
import Table from "react-bootstrap/Table";
import { formatPhoneNumberIntl } from "react-phone-number-input";

function ViewProfile(props) {
  var profile = props.profile;
  var phoneNumber = formatPhoneNumberIntl(profile.phone);
  return (
    <Card>
      <Form className="form">
        <h3 className={classes.heading}>Profile</h3>
        <hr />
        <h5>Personal Information</h5>
        <hr />
        <Table>
          <tbody>
            <tr>
              <td>Name</td>
              <td>{profile.name}</td>
            </tr>
            <tr>
              <td>Surname</td>
              <td>{profile.surname}</td>
            </tr>
            <tr>
              <td>Email</td>
              <td>{profile.email}</td>
            </tr>
            <tr>
              <td>Date of Birth</td>
              <td>{profile.dateOfBirth}</td>
            </tr>
            <tr>
              <td>Phone</td>
              <td>{phoneNumber}</td>
            </tr>
            <tr>
              <td>National ID</td>
              <td>{profile.nationalId}</td>
            </tr>
            <tr>
              <td>Gender</td>
              <td>{profile.gender}</td>
            </tr>
            <tr>
              <td>CGPA</td>
              <td>{profile.cgpa}</td>
            </tr>
          </tbody>
        </Table>
      </Form>
    </Card>
  );
}

export default ViewProfile;