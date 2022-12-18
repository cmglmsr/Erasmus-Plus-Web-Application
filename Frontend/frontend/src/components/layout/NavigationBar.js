import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { Link, useNavigate } from "react-router-dom";
import Cookies from "universal-cookie";

function NavigationBar() {
  var role = localStorage.getItem("role");
  console.log("navvv" + role);
  const navigate = useNavigate();

  function logout() {
    const cookies = new Cookies();
    cookies.remove("Erasmus+");
    var API = "http://localhost:8080/logout";
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
    };

    fetch(API, requestOptions).then((res) => navigate("/login"));
  }
  return (
    <header>
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand as={Link} to="/">
            Erasmus Bilkent
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            {role === "ROLE_STUDENT" && (
              <Nav className="ms-auto">
                <Nav.Link as={Link} to="/student/home">
                  Home
                </Nav.Link>
                <Nav.Link as={Link} to="/student/profile">
                  Profile
                </Nav.Link>
              </Nav>
            )}
            {role === "ROLE_COORDINATOR" && (
              <Nav className="ms-auto">
                <Nav.Link as={Link} to="/coordinator/home">
                  Home
                </Nav.Link>
                <Nav.Link as={Link} to="/coordinator/profile">
                  Profile
                </Nav.Link>
              </Nav>
            )}
            {role === "ROLE_INSTRUCTOR" && (
              <Nav className="ms-auto">
                <Nav.Link as={Link} to="/instructor/home">
                  Home
                </Nav.Link>
                <Nav.Link as={Link} to="/instructor/profile">
                  Profile
                </Nav.Link>
              </Nav>
            )}
            {role === "ROLE_ISO" && (
              <Nav className="ms-auto">
                <Nav.Link as={Link} to="/iso/home">
                  Home
                </Nav.Link>
                <Nav.Link as={Link} to="/iso/profile">
                  Profile
                </Nav.Link>
              </Nav>
            )}
            {role === "ROLE_FACULTY_BOARD_MEMBER" && (
              <Nav className="ms-auto">
                <Nav.Link as={Link} to="/fbm/home">
                  Home
                </Nav.Link>
                <Nav.Link as={Link} to="/fbm/profile">
                  Profile
                </Nav.Link>
              </Nav>
            )}
            <Form>
              <Button variant="danger" as={Link} onClick={logout}>
                Logout
              </Button>
            </Form>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </header>
  );
}
export default NavigationBar;
