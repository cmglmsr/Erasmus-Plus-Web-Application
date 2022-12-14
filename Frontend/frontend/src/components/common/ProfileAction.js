import ProfileSummary from "./ProfileSummary";
import ActionButtons from "./ActionButtons";
import Row from "react-bootstrap/Row";

function ProfileAction(props) {
  return (
    <div>
      <Row>
        <ProfileSummary profile={profile} />
      </Row>
      <Row className="my-4">
        <ActionButtons role={profile.roles[0]} />
      </Row>
    </div>
  );
}

export default ProfileAction;