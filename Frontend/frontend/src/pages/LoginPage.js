import LoginForm from "../components/LoginPage/LoginForm";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";

function LoginPage() {
  function onLoginHandler(loginData) {
    fetch(
      "https://react-course-bd5d1-default-rtdb.firebaseio.com/meetups.json", //enter api address
      {
        method: "POST",
        body: JSON.stringify(loginData),
      }
    );
  }
  return (
    <section>
      <Row className="justify-content-center">
        <Col xs={4}>
          <LoginForm onLogin={onLoginHandler} />
        </Col>
      </Row>
    </section>
  );
}

export default LoginPage;
