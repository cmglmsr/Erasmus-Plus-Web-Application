import LoginForm from "../components/LoginPage/LoginForm";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Cookies from 'universal-cookie';


function LoginPage() {
  var error;
  function onLoginHandler(loginData) {
    console.log(loginData);
    fetch(
      "http://localhost:8080/signin", //enter api address
      {
        method: "POST",
        credentials: 'same-origin',
        body: JSON.stringify(loginData),
        headers: {
          "Content-Type": "application/json"
        },
      }
    ).then((response) => {
      response.json().then((parsedJson) => {
        const cookies = new Cookies();
        if (response.status === 200) {
          document.cookie = parsedJson.cookie;
          if (parsedJson.roles[0] === "ROLE_STUDENT") {
            window.location.href = "http://localhost:3000/student/home";
          }
          else if (parsedJson.roles[0] === "ROLE_COORDINATOR") {
            window.location.href = "http://localhost:3000/coordinator/home";
          }
        }
        else if (response.status === 401) {
          var error = parsedJson.message;
          console.log(error);
        }
        console.log("COOKIE ===>", response.headers['Set-Cookie']);
      });
    });
  }
  return (
    <section>
      <Row className="justify-content-center">
        <Col xs={4}>
          <LoginForm onLogin={onLoginHandler} alert={error}/>
        </Col>
      </Row>
    </section>
  );
}

export default LoginPage;
