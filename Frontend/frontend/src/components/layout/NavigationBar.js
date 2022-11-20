import { Link } from "react-router-dom";
import classes from './NavigationBar.module.css';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

function NavigationBar() {
  return (
    <header>

      <Navbar bg="light" expand="lg">
      <Container>
        <Navbar.Brand href="#home">Erasmus Bilkent</Navbar.Brand>
        <Navbar.Text>
            Student
          </Navbar.Text>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ms-auto">
            <Nav.Link href="/">Home</Nav.Link>
            <Nav.Link href="#link">Profile</Nav.Link>
          </Nav>
          <Form inline >
              <Button variant="danger" href="/logout">Logout</Button>
            </Form>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    </header>
    
  );
}
export default NavigationBar;
