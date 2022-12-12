import React from "react";
import { useFormInputValidation } from "react-form-input-validation";
import Col from "react-bootstrap/Col";

import Card from "../UI/Card";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";

const ValidationForm = (props) => {
  const [fields, errors, form] = useFormInputValidation(
    {
      email: "",
      password: "",
    },
    {
      email: "required|email",
      password: "required",
    }
  );

  const onSubmit = async (event) => {
    const isValid = await form.validate(event);
    if (isValid) {
      console.log(fields, errors);
      props.onLogin(fields);
    }
  };
  return (
    <Card>
      <Form className="form" onSubmit={onSubmit}>
        <h3 className="heading">Login</h3>
        <hr/>
        <Form.Group className="mb-3" controlId="loginEmailInput">
          <Form.Label>Email</Form.Label>
          <Form.Control
            type="email"
            name="email"
            onBlur={form.handleBlurEvent}
            onChange={form.handleChangeEvent}
            value={fields.email}
            placeholder="Enter Email"
          />
          <label className="error">{errors.email ? errors.email : ""}</label>
        </Form.Group>

        <Form.Group className="mb-3" controlId="loginPasswordInput">
          <Form.Label>Password</Form.Label>
          <Form.Control
            type="password"
            name="password"
            onBlur={form.handleBlurEvent}
            onChange={form.handleChangeEvent}
            value={fields.password}
            placeholder="Password"
          />
          <label className="error">
            {errors.password ? errors.password : ""}
          </label>
        </Form.Group>

        <Col className="text-center">
          <Button className="button-default" type="submit">
            Login
          </Button>
        </Col>
      </Form>
    </Card>
  );
};

export default ValidationForm;
