import Form from "react-bootstrap/Form";
import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./ApplicationForm.module.css";

const timePeriod = {
  1: "Fall Semester",
  2: "Spring Semester",
  3: "Fall & Spring Semester",
};
const ApplicationDetailsCoordinator = ({
  fullname,
  id,
  school,
  status,
  pref1,
  pref2,
  pref3,
  pref4,
  pref5,
  term,
  uid,
  cgpa,
}) => {
  
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
              <td>Full Name</td>
              <td>{fullname}</td>
            </tr>
            <tr>
              <td>Bilkent ID</td>
              <td>{id}</td>
            </tr>
            <tr>
              <td>CGPA</td>
              <td>{cgpa}</td>
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
              <td>{pref1}</td>
            </tr>
            <tr>
              <td>2nd Preference</td>
              <td>{pref2}</td>
            </tr>
            <tr>
              <td>3rd Preference</td>
              <td>{pref3}</td>
            </tr>
            <tr>
              <td>4th Preference</td>
              <td>{pref4}</td>
            </tr>
            <tr>
              <td>5th Preference</td>
              <td>{pref5}</td>
            </tr>
          </tbody>
        </Table>
      </Form>
    </Card>
  );
};
export default ApplicationDetailsCoordinator;
