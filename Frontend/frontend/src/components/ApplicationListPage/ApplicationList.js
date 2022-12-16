import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./ApplicationList.module.css";
import { ApplicationListContext } from "../../context/ApplicationContext/ApplicationListContext";
import { useContext } from "react";

function ApplicationList() {
  const applicationList = useContext(ApplicationListContext);

  console.log(applicationList);
  return (
    <Card>
      <h3 className="heading my-3">Applications List</h3>
      <hr />
      <div className={classes.scrollable}>
        <Table>
          <thead>
            <tr key="head">
              <th>Fullname</th>
              <th>ID </th>
              <th>CGPA</th>
              <th>Placement</th>
              <th>Status</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {applicationList.map((application) => (
              <tr key={application.id}>
                <td>{application.fullname}</td>
                <td>{application.id}</td>
                <td>{application.cgpa}</td>
                <td>{application.school ? application.school : "Not Determined"}</td>
                <td>{application.status}</td>
                <td>
                  <Button key={application.id} className="button-default">View Application</Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    </Card>
  );
}

export default ApplicationList;
