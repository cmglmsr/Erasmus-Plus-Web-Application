import Table from "react-bootstrap/Table";
import Card from "../UI/Card";
import classes from "./ApplicationList.module.css";
import { useContext } from "react";
import PlacementListContext from "../../context/PlacementListContext/PlacementListContext";
import { Col, Row, Form, Button } from "react-bootstrap";

function PlacementList() {
  const placementList = useContext(PlacementListContext);
  console.log(placementList);

  function makePlacements() {
    var API = "http://localhost:8080/coordinator/placements/create";
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
    };

    fetch(API, requestOptions)
      .then((res) => {window.location.reload();
      })
      .catch((e) => {
        console.log(e);
      });
  }

  function finalizePlacements() {
    var API = "http://localhost:8080/coordinator/placements/finalize";
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
    };

    fetch(API, requestOptions)
      .then((res) => {window.location.reload();
      })
      .catch((e) => {
        console.log(e);
      });
  }

  return (
    <Card>
      <h3 className="heading my-3">Placements List</h3>
      <hr />
      <div className={classes.scrollable}>
        <Table>
          <thead>
            <tr key="head">
              <th>Fullname</th>
              <th>ID </th>
              <th>CGPA</th>
              <th>Placement</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {placementList.map((placement) => (
              <tr key={placement.uid}>
                <td>{placement.fullname}</td>
                <td>{placement.id}</td>
                <td>{placement.cgpa}</td>
                <td>{placement.school}</td>
                <td>{placement.status}</td>
              </tr>
            ))}
          </tbody>
        </Table>
        <Form.Group as={Row} className="mt-4" controlId="formPlaintextEmail">
          <Col className="text-center">
            <Button
              variant="primary"
              className="button-default mx-3"
              onClick={makePlacements}
            >
              Make Placements
            </Button>
            <Button variant="primary" className="button-default mx-3" onClick={finalizePlacements}>
              Finalize Placements
            </Button>
          </Col>
        </Form.Group>
      </div>
    </Card>
  );
}

export default PlacementList;
