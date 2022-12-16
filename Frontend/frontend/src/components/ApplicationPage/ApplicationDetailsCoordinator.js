import Form from "react-bootstrap/Form";
import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./ApplicationForm.module.css";
import { useParams } from "react-router-dom";
import { useContext } from "react";
import ApplicationListContext from "../../context/ApplicationContext/ApplicationListContext";

const timePeriod = {
  1: "Fall Semester",
  2: "Spring Semester",
  3: "Fall & Spring Semester",
};
const ApplicationDetailsCoordinator = () => {
    const applicationList = useContext(ApplicationListContext);
    const params = useParams();
    const application = applicationList.filter(
      (application) => application.id === params.id
    )[0];
  
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
              <td>{application.fullname}</td>
            </tr>
            <tr>
              <td>Bilkent ID</td>
              <td>{application.id}</td>
            </tr>
            <tr>
              <td>CGPA</td>
              <td>{application.cgpa}</td>
            </tr>
          </tbody>
        </Table>
        <h6>Status</h6>
        <hr className={classes.simple} />
        <Table>
          <tbody>
            <tr>
              <td>Status</td>
              <td>{application.status}</td>
            </tr>
          </tbody>
        </Table>
        <h6>Erasmus Preferences</h6>
        <hr className={classes.simple} />
        <Table>
          <tbody>
            <tr>
              <td>Time Period</td>
              <td>{timePeriod[application.term]}</td>
            </tr>
            <tr>
              <td>1st Preference</td>
              <td>{application.pref1}</td>
            </tr>
            <tr>
              <td>2nd Preference</td>
              <td>{application.pref2}</td>
            </tr>
            <tr>
              <td>3rd Preference</td>
              <td>{application.pref3}</td>
            </tr>
            <tr>
              <td>4th Preference</td>
              <td>{application.pref4}</td>
            </tr>
            <tr>
              <td>5th Preference</td>
              <td>{application.pref5}</td>
            </tr>
          </tbody>
        </Table>
      </Form>
    </Card>
  );
};
export default ApplicationDetailsCoordinator;
