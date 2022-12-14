import ProfileSummary from "./ProfileSummary";
import ActionButtons from "./ActionButtons";
import Row from "react-bootstrap/Row";

function ProfileAction(props) {
  return (
    <div>
      <Row>
        <ProfileSummary profile={props.user} />
      </Row>
      <Row className="my-4">
        <ActionButtons profile={props.user.roles[0]} />
      </Row>
    </div>
  );
}

export default ProfileAction;