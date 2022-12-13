import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import React from "react";

class SemesterCheckbox extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      group1: false,
      group2: false,
      group3: false,
    };
  }

  toggle1 = () => {
    this.setState({
      group1: !this.state.group1,
      group2: false,
      group3: false,
    });
  };

  toggle2 = () => {
    this.setState({
        group2: !this.state.group2,
      group1: false,
      group3: false,
    });
  };

  toggle3 = () => {
    this.setState({
        group3: !this.state.group3,
      group2: false,
      group1: false,
    });
  };

  render() {
    return (
      <Form.Group as={Row} className="my-3" controlId="preferredPeriod">
        <Col sm="3">Time Period</Col>
        <Col>
          <Form.Check
            inline
            label="Fal Semester Only"
            name="group1"
            type="checkbox"
            onChange={this.toggle1}
            defaultChecked={this.state.group1}
          />
          <Form.Check
            inline
            label="Spring Semester Only"
            name="group2"
            type="checkbox"
            onChange={this.toggle2}
            defaultChecked={this.state.group2}
          />
          <Form.Check
            inline
            label="Fal & Spring Semesters"
            type="checkbox"
            name="group3"
            onChange={this.toggle3}
            defaultChecked={this.state.group3}
          />
        </Col>
      </Form.Group>
    );
  }
}

export default SemesterCheckbox;
