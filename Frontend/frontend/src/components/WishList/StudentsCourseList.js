import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import React, { useState, useEffect } from "react";
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import UnapprovedCourse from "./UnapprovedCourse";
import ReactDeleteRow from "react-delete-row";
import classes from "./StudentsCourseList.module.css";
import ApprovedCoursesList from "./ApprovedCoursesList";

const wishlist = [
  {
    courseName: "aa",
    courseCode: "bb",
    hostUniversityName: "cc",
    approvedNotapproved: "Approved",
  },
  {
    courseName: "bb",
    courseCode: "cc",
    hostUniversityName: "ff",
    approvedNotapproved: "Approved",
  },
];



function StudentsCourseList(props) {
  const [mapItem, setMapItem] = useState([]);


  function gettingCourse(value) {
    if (value.courseCode != "") {
      console.log(value);
      if (mapItem.length == 0) setMapItem([value]);
      else setMapItem(mapItem.concat(value));
    }
  }

  function onSubmit(){
    fetch(
      "http://localhost:8080/student/createCourseWishlist", //enter api address
      {
        method: "POST",
        credentials: "include",
        body: JSON.stringify(wishlist),
      }
    );
    console.log("FRONTENDIN ALLAHI GORMEK ISTIYOR", wishlist)
  }

  return (
    <div>
      <Form className="form" onSubmit={() => onSubmit}>
      <Card>
        <h3 className="heading my-3">Wishlist</h3>
        <hr />
        <div className={classes.scrollable}>
          <Table>
            <thead>
              <tr>
                <th>Course Name</th>
                <th>Course Code </th>
                <th>University</th>
                <th>Approved/Unapproved</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              {mapItem.map((item, i) => {
                console.log(item);
                return (
                  <ReactDeleteRow
                    deleteElement={<i className={classes.button}>DROP</i>}
                    key={i}
                    data={item}
                    onDelete={(item) => {
                      return window.confirm(`Are you sure?`);
                    }}
                  >
                    <td>{item.courseName}</td>
                    <td>{item.courseCode}</td>
                    <td>{item.hostUniversityName}</td>
                    <td>{item.approvedNotapproved}</td>
                  </ReactDeleteRow>
                );
              })}
            </tbody>
          </Table>
        </div>
        <Form.Group as={Row} className="my-4" controlId="formPlaintextEmail">
          <Col className="text-center">
            <Button variant="primary" className="button-default" type="submit">
              Send to Instructor
            </Button>
          </Col>
        </Form.Group>
      </Card>
      <Row className="my-4">
        <ApprovedCoursesList
          getCourse={(e) => gettingCourse(e)}
        ></ApprovedCoursesList>
      </Row>
      <Row className="my-4">
        <UnapprovedCourse
          getCourse={(e) => gettingCourse(e)}
        ></UnapprovedCourse>
      </Row>
      </Form>
    </div>
  );
}

export default StudentsCourseList;
