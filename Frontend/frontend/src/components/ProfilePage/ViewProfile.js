import Form from "react-bootstrap/Form";
import Card from "../UI/Card";
import classes from "./ProfileDetails.module.css";
import "react-phone-input-2/lib/material.css";
import Table from "react-bootstrap/Table";
import { formatPhoneNumberIntl } from "react-phone-number-input";

const ViewProfile = ({name, surname, phone, email, dateOfBirth, gender, cgpa, nationalId, eng101grade, eng102grade}) => {
  var phoneNumber = formatPhoneNumberIntl(phone);
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
              <td>{name}</td>
            </tr>
            <tr>
              <td>Surname</td>
              <td>{surname}</td>
            </tr>
            <tr>
              <td>Email</td>
              <td>{email}</td>
            </tr>
            <tr>
              <td>Date of Birth</td>
              <td>{dateOfBirth}</td>
            </tr>
            <tr>
              <td>Phone</td>
              <td>{phoneNumber}</td>
            </tr>
            <tr>
              <td>National ID</td>
              <td>{nationalId}</td>
            </tr>
            <tr>
              <td>Gender</td>
              <td>{gender}</td>
            </tr>
            <tr>
              <td>CGPA</td>
              <td>{cgpa}</td>
            </tr>
            <tr>
              <td>ENG101 Grade</td>
              <td>{eng101grade}</td>
            </tr>
            <tr>
              <td>ENG102 Grade</td>
              <td>{eng102grade}</td>
            </tr>
          </tbody>
        </Table>
      </Form>
    </Card>
  );
}

export default ViewProfile;