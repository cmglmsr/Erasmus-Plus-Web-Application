import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./PreApprovalForm.module.css";
import { Table } from "react-bootstrap";
import { useState } from "react";
import template from "../../assets/preappTemplate.pdf";

const PreApprovalForm = ({ status }) => {
  const [file, setFile] = useState({});

  var download = "";

  if (status == "UPLOADED") {
    download = (
      <Button
        variant="primary"
        className="button-default mx-3"
        type="submit"
        onClick={downloadForm}
      >
        Download
      </Button>
    );
  }

  function handleFile(event) {
    setFile(event.target.files[0]);
  }

  function onSubmit(event) {
    event.preventDefault();
    var data = new FormData();
    data.append("preApproval", file);

    var myHeaders = new Headers();

    var requestOptions = {
      method: "POST",
      headers: myHeaders,
      body: data,
      credentials: "include",
      redirect: "follow",
    };

    fetch("http://localhost:8080/student/upload/preapproval", requestOptions)
      .then((response) => {
        response.text();
        if (response.status === 200) {
          window.confirm("PreApproval Uploaded.");
          window.location.reload();
        }
      })
      .then((result) => {
        console.log(result);
      })
      .catch((error) => console.log("error", error))
      .then((response) => {});
  }

  function downloadForm(event) {
    event.preventDefault();
    var API = `http://localhost:8080/student/download/preapproval`;
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
    };

    fetch(API, requestOptions).then((res) => {
        res.blob();
    }).then((blob) => {
      // Create blob link to download
      const url = window.URL.createObjectURL(
          new Blob([blob]),
      );
      const link = document.createElement('a');
      link.href = url;
      link.setAttribute(
          'download',
          `PreApproval.pdf`,
      );
      link.click();
    });
  }

  function downloadTemplate() {
    var API = `http://localhost:8080/student/download/preapproval`;
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
    };

    fetch(API, requestOptions).then((res) => {
      res.json().then((data) => {
        console.log("aaaaaaaaaaaaaaaa" + data);
      });
    });
  }
  return (
    <Card>
      <Form className="form">
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
            <Form.Control type="file" onChange={handleFile} accept=".pdf"/>
          </Col>
        </Form.Group>

        <Form.Group as={Row} className="mt-4" controlId="formPlaintextEmail">
          <Col className="text-center">
          <Button href={template}
              variant="primary"
              className="button-default mx-3"
              onClick={downloadTemplate}
            >
              Download Template
            </Button>
            <Button
              variant="primary"
              className="button-default mx-3"
              type="submit"
              onClick={onSubmit}
            >
              Save Changes
            </Button>
            {download}
          </Col>
        </Form.Group>
      </Form>
    </Card>
  );
};

export default PreApprovalForm;
