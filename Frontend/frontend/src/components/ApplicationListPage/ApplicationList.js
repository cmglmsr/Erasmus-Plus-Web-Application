import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./ApplicationList.module.css"

const APPLICATION_LIST = [
  {
    fullName: "Elifsena Öz",
    studentId: "22002245",
    CGPA: "3.32",
    placement: "EPFL",
    status: "WAITING COORDINATOR",
  },
  {
    fullName: "Eren Duran",
    studentId: "22002339",
    CGPA: "3.92",
    placement: "Vrije Universiteit Amsterdam",
    status: "COORDINATOR APPROVED",
  },
  {
    fullName: "Aslı Karaman",
    studentId: "22002255",
    CGPA: "3.49",
    placement: "EPITA",
    status: "DENIED",
  },
  {
    fullName: "Cem Gülümser",
    studentId: "22003330",
    CGPA: "3.64",
    placement: "Oxford University",
    status: "APPROVED",
  }
];

function ApplicationList(props) {
  return (
    <Card>
      <h3 className="heading my-3">Applications List</h3>
      <hr />
      <div className={classes.scrollable}>
      <Table>
        <thead>
          <tr>
            <th>Fullname</th>
            <th>ID </th>
            <th>CGPA</th>
            <th>School</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {APPLICATION_LIST.map((application) => (
            <tr>
              <td>{application.fullName}</td>
              <td>{application.studentId}</td>
              <td>{application.CGPA}</td>
              <td>{application.placement}</td>
              <td>{application.status}</td>
              <td>
                <Button className="button-default">View Application</Button>
              </td>
            </tr>
          ))}
                    {APPLICATION_LIST.map((application) => (
            <tr>
              <td>{application.fullName}</td>
              <td>{application.studentId}</td>
              <td>{application.CGPA}</td>
              <td>{application.placement}</td>
              <td>{application.status}</td>
              <td>
                <Button className="button-default">View Application</Button>
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
