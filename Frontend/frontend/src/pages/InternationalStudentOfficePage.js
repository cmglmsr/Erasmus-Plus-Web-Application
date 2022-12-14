import ProfileAction from "../components/common/ProfileAction";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ToDoList from "../components/HomePage/ToDoList";
import Schedule from "../components/HomePage/Schedule";
import { useEffect } from "react";

const DUMMY_PROFILE = {
  role: "International Student Office",
  image: "https://cdn-icons-png.flaticon.com/512/3135/3135823.png",
  id: 11111111,
  name: "Selen",
  surname: "Gülsever"
};

function InternationalStudentOfficePage() {
  useEffect(() => {
    fetch(`https://jsonplaceholder.typicode.com/posts`).then((response) =>
      console.log(response)
    );
  }, []);

  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <ProfileAction profile={DUMMY_PROFILE} />
        </Col>
        <Col className="mx-4">
        <div>
          <Row>
            <ToDoList />
          </Row>
          <Row className="my-4">
            <Schedule />
          </Row>
        </div>
      </Col>
    </Row>
    </section>
  );
}

export default InternationalStudentOfficePage;