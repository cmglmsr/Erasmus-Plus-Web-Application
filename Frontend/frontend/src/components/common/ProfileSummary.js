import Table from "react-bootstrap/Table";
import classes from "./ProfileSummary.module.css";
import Card from "../UI/Card";

const ProfileSummary = ({name, surname, role, term, image, bilkentId, department}) => {

  const roles = {
    "ROLE_STUDENT": "Student",
    "ROLE_COORDINATOR": "Coordinator",
    "ROLE_INSTRUCTOR": "Instructor",
    "ROLE_ISO": "International Student Office",
    "ROLE_FBM": "Faculty Board Member",
  }
  var semesterComp;
  var table;

  if (role === "ROLE_STUDENT") {
    semesterComp = (
      <tr>
        <th>Semester</th>
        <td>{term}</td>
      </tr>
    );
  }

  if(role === "ROLE_ISO"){
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
          <th colSpan={2}>{roles[role]}</th>
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
          <td>{bilkentId}</td>
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
          <th colSpan={2}>{roles[role]}</th>
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
          <td>{bilkentId}</td>
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
