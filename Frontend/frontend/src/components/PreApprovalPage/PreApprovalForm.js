import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./PreApprovalForm.module.css";
import { Table } from "react-bootstrap";

const PreApprovalForm = ({ status }) => {
  function onSubmit(event) {
    event.preventDefault();
  }

  return (
    <Card>
      <Form className="form" onSubmit={onSubmit}>
        <h3 className={classes.heading}>PreApproval Form</h3>
        <hr />
        <h5>Status</h5>
        <hr />
        <Table>
          <tbody>
            <tr>
              <td>Status</td>
              <td>{status}</td>
            </tr>
          </tbody>
        </Table>
        <h5>Document</h5>
        <hr />

        <Form.Group as={Row} className="my-3">
          <Form.Label column sm="3">
            PreApproval Form
          </Form.Label>
          <Col>
            <Form.Control type="file" />
          </Col>
        </Form.Group>

        <Form.Group as={Row} className="mt-4" controlId="formPlaintextEmail">
          <Col className="text-center">
            <Button variant="primary" className="button-default" type="submit">
              Save Changes
            </Button>
          </Col>
        </Form.Group>
      </Form>
    </Card>
  );
};

export default PreApprovalForm;
