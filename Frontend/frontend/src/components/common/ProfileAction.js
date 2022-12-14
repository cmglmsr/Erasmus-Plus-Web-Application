import ProfileSummary from "./ProfileSummary";
import ActionButtons from "./ActionButtons";
import Row from "react-bootstrap/Row";

function ProfileAction(props) {
  const profile = props.profile;
  return (
    <div>
      <Row>
        <ProfileSummary profile={profile} />
      </Row>
      <Row className="my-4">
        <ActionButtons role={profile.role} />
      </Row>
    </div>
  );
}

export default ProfileAction;