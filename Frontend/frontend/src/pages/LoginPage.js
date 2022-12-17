import LoginForm from "../components/LoginPage/LoginForm";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import { useState } from "react";

function LoginPage() {
  const [error, setError] = useState("")
  function onLoginHandler(loginData) {
    console.log(loginData);
    fetch(
      "http://localhost:8080/signin", //enter api address
      {
        method: "POST",
        credentials: 'include',
        body: JSON.stringify(loginData),
        headers: {
          "Content-Type": "application/json"
        },
      }
    ).then((response) => {
      response.json().then((parsedJson) => {
        console.log("a" + parsedJson);
        if (response.status === 200) {
          localStorage.setItem("role", parsedJson.role);

          /// DONT EVER TOUCH THIS LINE
          document.cookie = parsedJson.cookie+ ";SameSite=None;";
          // DANGER DANGER DANGER

          if (parsedJson.role === "ROLE_STUDENT") {
            window.location.href = "http://localhost:3000/student/home";
          }
          else if (parsedJson.role === "ROLE_COORDINATOR") {
            window.location.href = "http://localhost:3000/coordinator/home";
          }
          else if (parsedJson.role === "ROLE_INSTRUCTOR") {
            window.location.href = "http://localhost:3000/instructor/home";
          }
          else if (parsedJson.role === "ROLE_ISO") {
            window.location.href = "http://localhost:3000/iso/home";
          }
          else if (parsedJson.role === "ROLE_FBM") {
            window.location.href = "http://localhost:3000/fbm/home";
          }
        }
        else if (response.status === 401) {
          setError(parsedJson.message);
          window.confirm("Invalid credentials.");
        }
        console.log("COOKIE ===>", response.headers['Set-Cookie']);
      });
    });
  }
  return (
    <section>
      <Row className="justify-content-center">
        <Col xs={4}>
          <LoginForm onLogin={onLoginHandler} error={error}/>
        </Col>
      </Row>
    </section>
  );
}

export default LoginPage;
