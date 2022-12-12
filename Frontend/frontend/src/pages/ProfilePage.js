import ProfileDetails from "../components/ProfilePage/ProfileDetails";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ProfileAction from "../components/common/ProfileAction";

function ProfilePage(props) {
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <ProfileAction profile={props.profile} />
        </Col>
        <Col className="mx-3">
          <ProfileDetails profile={props.profile} />
        </Col>
      </Row>
    </section>
  );
}

export default ProfilePage;
