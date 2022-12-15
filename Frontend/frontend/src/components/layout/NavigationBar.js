import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import { Link } from "react-router-dom";

function NavigationBar() {
  var role = localStorage.getItem("role");
  console.log("navvv" + role);
  return (
    <header>
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand as={Link} to="/">
            Erasmus Bilkent
          </Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="ms-auto">
              {role === "ROLE_STUDENT" && (
                <Nav.Link as={Link} to="/student/home">
                  Home
                </Nav.Link>
              )}
              {role === "ROLE_COORDINATOR" && (
                <Nav.Link as={Link} to="/coordinator/home">
                  Home
                </Nav.Link>
              )}
              {role === "ROLE_INSTRUCTOR" && (
                <Nav.Link as={Link} to="/instructor/home">
                  Home
                </Nav.Link>
              )}
              {role === "ROLE_ISO" && (
                <Nav.Link as={Link} to="/iso/home">
                  Home
                </Nav.Link>
              )}
              {role === "ROLE_FBM" && (
                <Nav.Link as={Link} to="/fbm/home">
                  Home
                </Nav.Link>
              )}
              {role === "ROLE_STUDENT" && (
                <Nav.Link as={Link} to="/student/profile">
                  Profile
                </Nav.Link>
              )}
              {role === "ROLE_COORDINATOR" && (
                <Nav.Link as={Link} to="/coordinator/profile">
                  Profile
                </Nav.Link>
              )}
              {role === "ROLE_INSTRUCTOR" && (
                <Nav.Link as={Link} to="/instructor/profile">
                  Profile
                </Nav.Link>
              )}
              {role === "ROLE_ISO" && (
                <Nav.Link as={Link} to="/iso/profile">
                  Profile
                </Nav.Link>
              )}
              {role === "ROLE_FBM" && (
                <Nav.Link as={Link} to="/fbm/profile">
                  Profile
                </Nav.Link>
              )}
            </Nav>
            <Form>
              <Button variant="danger" as={Link} to="/logout">
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
