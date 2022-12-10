import Table from "react-bootstrap/Table";
import Container from "react-bootstrap/Container";
import classes from "./ProfileSummary.module.css";
import Card from "../UI/Card";

function ProfileSummary(props) {
  var profile = props.profile;
  return (
    <Card>
        <Table className={classes.table}>
          <thead className={classes.head}>
            <tr>
              <th colSpan={2}>
                <img
                  className={classes.image}
                  alt="profileImage"
                  src={profile.image}
                ></img>
              </th>
            </tr>
            <tr>
              <th colSpan={2}>{profile.role}</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <th>Name</th>
              <td>{profile.name}</td>
            </tr>
            <tr>
              <th>Surname</th>
              <td>{profile.surname}</td>
            </tr>
            <tr>
              <th>Bilkent ID</th>
              <td>{profile.id}</td>
            </tr>
            <tr>
              <th>Department</th>
              <td>{profile.department}</td>
            </tr>
          </tbody>
        </Table>
    </Card>
  );
}
export default ProfileSummary;
