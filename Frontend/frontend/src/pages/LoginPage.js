import LoginForm from "../components/LoginPage/LoginForm";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";

function LoginPage() {
  function onLoginHandler(loginData) {
      console.log(loginData);
    fetch(
      "http://localhost:8080/api/auth/signin", //enter api address
      {
        method: "POST",
        body: JSON.stringify(loginData), headers: {
              "Content-Type": "application/json",
          },
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
