import LoginForm from "../components/LoginPage/LoginForm";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";

function LoginPage() {
  function onLoginHandler(loginData) {
    fetch(
      "https://http://localhost:8080/login", //enter api address
      {
        method: "POST",
        body: JSON.stringify(loginData),
      }
    ).then((response) => {
      response.json().then((parsedJson) => {
        if (response.status === 200) {
          if (parsedJson.roles[0] === "ROLE_STUDENT") {
            window.location.href = "http://localhost:3000/student";
          }
          else if (parsedJson.roles[0] === "ROLE_COORDINATOR") {
            window.location.href = "http://localhost:3000/coordinator";
          }
          if (parsedJson.roles[0] === "ROLE_STUDENT") {
            window.location.href = "http://localhost:3000/";
          }
          if (parsedJson.roles[0] === "ROLE_STUDENT") {
            window.location.href = "http://localhost:3000/";
          }
        }
        else if (response.status === 401) {
          var error = parsedJson.message;
          console.log(error);
        }
      });
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
