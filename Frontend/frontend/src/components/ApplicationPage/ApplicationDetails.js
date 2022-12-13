import { formatPhoneNumberIntl } from "react-phone-number-input";
import { useFormInputValidation } from "react-form-input-validation";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import React from "react";

import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./ApplicationDetails.module.css";
import SemesterCheckbox from "./SemesterCheckbox";

const ValidationForm = (props) => {
  var application = props.application;
  var phoneNumber = formatPhoneNumberIntl(application.phone);

  const [fields, errors, form] = useFormInputValidation(
    {
      semester: "",
      firstPreference: "",
      secondPreference: "",
      thirdPreference: "",
      fourthPreference: "",
      fifthPreference: "",
      file: "",
    },
    {
      //checkBox: "required",
      firstPreference: "required",
      secondPreference: "required",
      thirdPreference: "required",
      fourthPreference: "required",
      fifthPreference: "required",
      file: "required",
    }
  );

  const onSubmit = async (event) => {
    const isValid = await form.validate(event);
    if (isValid) {
      console.log(fields, errors);
      props.application(fields);
    }
  };
  return (
    <Card>
      <Form className="form" onSubmit={onSubmit}>
        <h3 className={classes.heading}>Application</h3>
        <hr />
        <h6>Contact Information</h6>
        <hr className={classes.simple} />
        <Table>
          <tbody>
            <tr>
              <td>Email</td>
              <td>{application.email}</td>
            </tr>
            <tr>
              <td>Address</td>
              <td>{application.address}</td>
            </tr>
            <tr>
              <td>Phone Number</td>
              <td>{phoneNumber}</td>
            </tr>
          </tbody>
        </Table>
        <h6>Erasmus Preferences</h6>
        <hr className={classes.simple} />

        <SemesterCheckbox name="semester" value={fields.semester}></SemesterCheckbox>

        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            1st Preference
          </Form.Label>
          <Col>
            <Form.Select
              aria-label="secondPreference"
              name="firstPreference"
              type="select"
              onBlur={form.handleBlurEvent}
              onChange={form.handleChangeEvent}
              value={fields.firstPreference}
            >
              <option disabled></option>
              <option value="1">
                Ecole Polytechnique Federale de Lausanne (EPFL)-Switzerland
              </option>
              <option value="2"></option>
            </Form.Select>
            <label className="error">{errors.mail ? errors.mail : ""}</label>
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            2nd Preference
          </Form.Label>
          <Col>
            <Form.Select
              aria-label="secondPreference"
              name="secondPreference"
              type="select"
              onBlur={form.handleBlurEvent}
              onChange={form.handleChangeEvent}
              value={fields.secondPreference}
            >
              <option>Vrije Universiteit Amsterdam-The Netherlands</option>
              <option value="1">Male</option>
              <option value="2">Female</option>
            </Form.Select>
            <label className="error">{errors.mail ? errors.mail : ""}</label>
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            3rd Preference
          </Form.Label>
          <Col>
            <Form.Select
              aria-label="thirdPreference"
              name="thirdPreference"
              type="select"
              onBlur={form.handleBlurEvent}
              onChange={form.handleChangeEvent}
              value={fields.thirdPreference}
            >
              <option>
                Ecole Pour Linformatique Et Les Techniques Avancees
                (EPITA)-France
              </option>
              <option value="1">Male</option>
              <option value="2">Female</option>
            </Form.Select>
            <label className="error">{errors.mail ? errors.mail : ""}</label>
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            4th Preference
          </Form.Label>
          <Col>
            <Form.Select
              aria-label="fourthPreference"
              name="fourthPreference"
              type="select"
              onBlur={form.handleBlurEvent}
              onChange={form.handleChangeEvent}
              value={fields.fourthPreference}
            >
              <option>Kingston University-U.K.</option>
              <option value="1">Male</option>
              <option value="2">Female</option>
            </Form.Select>
            <label className="error">{errors.mail ? errors.mail : ""}</label>
          </Col>
        </Form.Group>
        <Form.Group as={Row} className="my-3" controlId="formPlaintextEmail">
          <Form.Label column sm="3">
            5th Preference
          </Form.Label>
          <Col>
            <Form.Select
              aria-label="fifthPreference"
              name="fifthPreference"
              type="select"
              onBlur={form.handleBlurEvent}
              onChange={form.handleChangeEvent}
              value={fields.fifthPreference}
            >
              <option></option>
              <option value="1">Male</option>
              <option value="2">Female</option>
            </Form.Select>
            <label className="error">{errors.mail ? errors.mail : ""}</label>
          </Col>
        </Form.Group>

        <h6>Documents</h6>
        <hr />
        <Form.Group as={Row} controlId="formFile" className="mb-3">
          <Form.Label column sm="3">
            CV
          </Form.Label>
          <Col>
            <Form.Control name="file" type="file" />
            <label className="error">{errors.mail ? errors.mail : ""}</label>
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
export default ValidationForm;
