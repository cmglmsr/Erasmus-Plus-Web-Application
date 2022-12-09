import ProfileSummary from "./ProfileSummary";
import ActionButtons from "./ActionButtons";
import Row from "react-bootstrap/Row";

export default function ProfileAction(props) {
  return (
    <>
      <Row>
        <ProfileSummary profile={props.profile} />
      </Row>
      <Row className="my-4">
        <ActionButtons role={props.profile.role} />
      </Row>
    </>
  );
}
