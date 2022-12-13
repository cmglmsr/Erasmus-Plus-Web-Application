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
        body: JSON.stringify(loginData),
        headers: {
          "Content-Type": "application/json",
        },
      }
    ).then((response) => {
      if (response.roles === "ROLE_STUDENT") {
        window.location.href = "http://localhost:8080/"
      }
      // HTTP 301 response
      // HOW CAN I FOLLOW THE HTTP REDIRECT RESPONSE?
    });
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
