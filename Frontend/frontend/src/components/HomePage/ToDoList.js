import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./ToDoList.module.css";
import React, { useState, useEffect } from "react";

function ToDoList() {
  const [dateState, setDateState] = useState(new Date());
  useEffect(() => {
    setInterval(() => setDateState(new Date()), 30000);
  }, []);
  return (
    <Card>
      <h3 className={classes.heading}>ToDoList</h3>

      <h4>
        Date:{" "}
        <p className={classes.p}>
          {" "}
          {dateState.toLocaleDateString("en-GB", {
            day: "numeric",
            month: "short",
            year: "numeric",
          })}
        </p>
      </h4>
      <Table className={classes.table}>
        <thead>
          <tr>
            <th scope="col"> Completed</th>
            <th scope="col">Description</th>
            <th scope="col">Due time</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">
              <div class="form-check">
                <input
                  class="form-check-input"
                  type="checkbox"
                  value=""
                  id="flexCheckDefault"
                />
              </div>
            </th>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <th scope="row">
              <div class="form-check">
                <input
                  class="form-check-input"
                  type="checkbox"
                  value=""
                  id="flexCheckDefault"
                />
              </div>
            </th>
            <td></td>
            <td></td>
          </tr>
          <tr>
            <th scope="row">
              <div class="form-check">
                <input
                  class="form-check-input"
                  type="checkbox"
                  value=""
                  id="flexCheckDefault"
                />
              </div>
            </th>
            <td></td>
            <td></td>
          </tr>
        </tbody>
      </Table>
    </Card>
  );
}
export default ToDoList;
