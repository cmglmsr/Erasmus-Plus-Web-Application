import ProfileAction from "../components/common/ProfileAction";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useEffect, useState } from "react";
import Schedule from "../components/HomePage/Schedule";
import ProfileSummary from "./ProfileSummary";

function Student() {
  const [profile, setProfile] = useState();
  useEffect(() => {
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
    };

    fetch("http://localhost:8080/student/home", requestOptions).then(
      (response) => response.json().then((parsedJson) => setProfile(parsedJson))
    );
  }, []);

  const profileAction = <ProfileAction profile={profile} />;
  console.log(profile);
  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <Row>
            <ProfileSummary
              name={profile.name}
              surname={profile.surname}
              role={profile.role}
              semester={profile.image}
              id={profile.id}
              image={profile.image}
              department={profile.department}
            />
          </Row>
          <Row className="my-4"></Row>
        </Col>
        <Col className="mx-4">
          <div>
            <Row className="my-3">
              <Schedule />
            </Row>
          </div>
        </Col>
      </Row>
    </section>
  );
}
export default Student;
