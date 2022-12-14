import { formatPhoneNumberIntl } from "react-phone-number-input";
import Form from "react-bootstrap/Form";
import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./ApplicationDetails.module.css";

function ViewApplication(props) {
  var application = props.application;
  var phoneNumber = formatPhoneNumberIntl(application.phone);
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
        <Table>
          <tbody>
            <tr>
              <td>Time Period</td>
              <td>{application.timePeriod}</td>
            </tr>
            <tr>
              <td>1st Preference</td>
              <td>{application.first}</td>
            </tr>
            <tr>
              <td>2nd Preference</td>
              <td>{application.second}</td>
            </tr>
            <tr>
              <td>3rd Preference</td>
              <td>{application.third}</td>
            </tr>
            <tr>
              <td>4th Preference</td>
              <td>{application.fourth}</td>
            </tr>
            <tr>
              <td>5th Preference</td>
              <td>{application.fifth}</td>
            </tr>
            <tr>
              <td>CV</td>
              <td>{application.cv}</td>
            </tr>
          </tbody>
        </Table>
      </Form>
    </Card>
  );
}
export default ViewApplication;
