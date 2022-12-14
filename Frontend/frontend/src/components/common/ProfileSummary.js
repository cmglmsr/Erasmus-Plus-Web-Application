import Table from "react-bootstrap/Table";
import Container from "react-bootstrap/Container";
import classes from "./ProfileSummary.module.css";
import Card from "../UI/Card";

const ProfileSummary = ({name, surname, role, semester, image, id, department}) => {

  var semesterComp;
  var table;

  if (role === "Student") {
    semesterComp = (
      <tr>
        <th>Semester</th>
        <td>{semester}</td>
      </tr>
    );
  }

  if(role == "International Student Office"){
    table = <Card>
    <Table>
      <thead className={classes.head}>
        <tr>
          <th colSpan={2}>
            <img
              className={classes.image}
              alt="profileImage"
              src={image}
            ></img>
          </th>
        </tr>
        <tr>
          <th colSpan={2}>{role}</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th>Name</th>
          <td>{name}</td>
        </tr>
        <tr>
          <th>Surname</th>
          <td>{surname}</td>
        </tr>
        <tr>
          <th>Bilkent ID</th>
          <td>{id}</td>
        </tr>
      </tbody>
    </Table>
  </Card>
  }else{
    table = <Card>
    <Table>
      <thead className={classes.head}>
        <tr>
          <th colSpan={2}>
            <img
              className={classes.image}
              alt="profileImage"
              src={image}
            ></img>
          </th>
        </tr>
        <tr>
          <th colSpan={2}>{role}</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th>Name</th>
          <td>{name}</td>
        </tr>
        <tr>
          <th>Surname</th>
          <td>{surname}</td>
        </tr>
        <tr>
          <th>Bilkent ID</th>
          <td>{id}</td>
        </tr>
        <tr>
          <th>Department</th>
          <td>{department}</td>
        </tr>
        {semesterComp}
      </tbody>
    </Table>
  </Card>
  }
  return table;
  
}
export default ProfileSummary;
