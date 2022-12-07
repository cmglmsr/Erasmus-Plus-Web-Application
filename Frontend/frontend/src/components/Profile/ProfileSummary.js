import Table from "react-bootstrap/Table";
import classes from "./ProfileSummary.module.css";
import Card from "../UI/Card";

function ProfileSummary(props) {
    var profile = props.profile;
  return (
    <Card width>
        <div className="container">
      <Table className={classes.table}>
                <thead className={classes.head}>
                <tr>
                    <th colSpan={2}><img className={classes.image} alt="profileImage" src={profile.image}></img></th>
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
                    <th>Department</th>
                    <td>{profile.department}</td>
                  </tr>
                </tbody>
      </Table>
      </div>
    </Card>
  );
}
export default ProfileSummary;
