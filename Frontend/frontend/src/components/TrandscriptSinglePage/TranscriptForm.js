import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./TranscriptForm.module.css";
import { Table } from "react-bootstrap";
import { useState } from "react";
import { useParams } from "react-router-dom";
import TranscriptListContext from "../../context/TranscriptContext/TranscriptListContext";
import { param } from "jquery";

const TranscriptForm = ({ status }) => {
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
    data.append("Transcript", file);

    var myHeaders = new Headers();

    var requestOptions = {
      method: "POST",
      headers: myHeaders,
      body: data,
      credentials: "include",
      redirect: "follow",
    };

    fetch("http://localhost:8080/student/upload/transcript", requestOptions)
      .then((response) => {
        response.text();
        if (response.status === 200) {
          window.confirm("Transcript Uploaded.");
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
    var API = `http://localhost:8080/student/download/transcript`;
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
    };

    fetch(API, requestOptions).then((res) => {
        res.blob().then((blob) => {
          // Create blob link to download
          const url = window.URL.createObjectURL(
              new Blob([blob]),
          );
          const link = document.createElement('a');
          link.href = url;
          link.setAttribute(
              'download',
              `Transcript.pdf`,
          );
          link.click();
        });
    })
  }

  return (
    <Card>
      <Form className="form">
        <h3 className={classes.heading}>Transcript</h3>
        <hr />
        <h5>Document</h5>
        <hr />

        <Form.Group as={Row} controlId="formFile" className="my-3">
          <Form.Label column sm="3">
            Transcript
          </Form.Label>
          <Col>
            <Form.Control type="file" onChange={handleFile} accept=".pdf"/>
          </Col>
        </Form.Group>

        <Form.Group as={Row} className="mt-4" controlId="formPlaintextEmail">
          <Col className="text-center">
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

export default TranscriptForm;
