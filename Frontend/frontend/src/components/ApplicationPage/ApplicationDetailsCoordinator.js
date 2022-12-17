import Form from "react-bootstrap/Form";
import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./ApplicationForm.module.css";
import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";

const timePeriod = {
  1: "Fall Semester",
  2: "Spring Semester",
  3: "Fall & Spring Semester",
};
const ApplicationDetailsCoordinator = () => {
  const [applicationData, setApplicationData] = useState({});
  const params = useParams();


  useEffect(() => {
    var API = `http://localhost:8080/coordinator/applications/${params.uid}`;
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
    };

    fetch(API, requestOptions).then((res) => {
        res.json().then((data) => {
          console.log("aaaaaaaaaaaaaaaa" + data);
          setApplicationData(data);
        });
      }
    );
  }, [params.uid]);

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
              <td>{applicationData.fullname}</td>
            </tr>
            <tr>
              <td>Bilkent ID</td>
              <td>{applicationData.id}</td>
            </tr>
            <tr>
              <td>CGPA</td>
              <td>{applicationData.cgpa}</td>
            </tr>
          </tbody>
        </Table>
        <h6>Status</h6>
        <hr className={classes.simple} />
        <Table>
          <tbody>
            <tr>
              <td>Status</td>
              <td>{applicationData.status}</td>
            </tr>
          </tbody>
        </Table>
        <h6>Erasmus Preferences</h6>
        <hr className={classes.simple} />
        <Table>
          <tbody>
            <tr>
              <td>Time Period</td>
              <td>{timePeriod[applicationData.term]}</td>
            </tr>
            <tr>
              <td>1st Preference</td>
              <td>{applicationData.pref1}</td>
            </tr>
            <tr>
              <td>2nd Preference</td>
              <td>{applicationData.pref2}</td>
            </tr>
            <tr>
              <td>3rd Preference</td>
              <td>{applicationData.pref3}</td>
            </tr>
            <tr>
              <td>4th Preference</td>
              <td>{applicationData.pref4}</td>
            </tr>
            <tr>
              <td>5th Preference</td>
              <td>{applicationData.pref5}</td>
            </tr>
          </tbody>
        </Table>
      </Form>
    </Card>
  );
};
export default ApplicationDetailsCoordinator;
