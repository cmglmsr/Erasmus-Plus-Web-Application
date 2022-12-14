import ProfileDetails from "../components/ProfilePage/ProfileDetails";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ProfileAction from "../components/common/ProfileAction";
import { useEffect } from "react";

function ProfilePage(props) {
  useEffect(() => {
    fetch(`https://jsonplaceholder.typicode.com/posts`).then((response) =>
      console.log(response)
    );
  }, []);
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
