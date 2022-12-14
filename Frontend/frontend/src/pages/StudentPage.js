import ProfileAction from "../components/common/ProfileAction";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { useEffect } from "react";
import ToDoList from "../components/HomePage/ToDoList";
import Schedule from "../components/HomePage/Schedule";

const DUMMY_PROFILE = {
  role: "Student",
  image: "https://cdn-icons-png.flaticon.com/512/3135/3135823.png",
  id: "21901576",
  name: "Aslı",
  surname: "Karaman",
  department: "Computer Engineering",
  semester: 3,
};

function Student() {
  useEffect(() => {
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: 'include',
      headers: {
        "Content-Type": "application/json",
        "Cookie": "Erasmus+=eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjZW1nQGhvdG1haWwuY29tIiwiaWF0IjoxNjcxMDM1MjEyLCJleHAiOjE2NzExMjE2MTJ9.ODn4qaBxIARCU8JDSrNApfgK7W-CK-TIzCgeP0aQZtscUDkvJAw103o_Pp-XaJxxoT17-v4pJmtQJniU635BTQ"
      },
    };

    var x = fetch("http://localhost:8080/student/home", requestOptions).then(
        (response) =>
            response.json().then((parsedJson) => console.log(parsedJson))
    );
    console.log(x)
  }, []);

  return (
    <section>
      <Row>
        <Col xs={3} className="mx-3">
          <ProfileAction profile={DUMMY_PROFILE} />
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
