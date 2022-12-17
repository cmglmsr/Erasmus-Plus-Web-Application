import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./PreApprovalForm.module.css";
import { Table } from "react-bootstrap";
import {useState }from "react";

const PreApprovalForm = ({ status }) => {
  const [file, setFile] = useState({});

  function handleFile(event) {
    setFile(event.target.files[0]);
  }

  function onSubmit(event) {
    event.preventDefault();
    var data = new FormData();
    data.append("preApproval", file);

    fetch(
        "http://localhost:8080/student/upload/preapproval", //enter api address
        {
          method: "POST",
          credentials: "include",
          body: data,
          headers: {
            "Content-Type": "multipart/form-data",
            "Accept": "application/json",
            "type": "formData",
          },
        }
      ).then((response) => {
        if (response.status === 200) {
          window.confirm("Preapproval Uploaded.");
        }
      });
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

        <Form.Group as={Row} controlId="formFile" className="my-3">
          <Form.Label column sm="3">
            PreApproval Form
          </Form.Label>
          <Col>
            <Form.Control type="file" onChange={handleFile} />
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
