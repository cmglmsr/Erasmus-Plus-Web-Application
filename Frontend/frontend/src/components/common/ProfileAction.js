import ProfileSummary from "./ProfileSummary";
import ActionButtons from "./ActionButtons";
import Row from "react-bootstrap/Row";

function ProfileAction(props) {
  return (
    <div>
      <Row>
        <ProfileSummary profile={props.profile} />
      </Row>
      <Row className="my-4">
        <ActionButtons role={props.profile.role} />
      </Row>
    </div>
  );
}

export default ProfileAction;