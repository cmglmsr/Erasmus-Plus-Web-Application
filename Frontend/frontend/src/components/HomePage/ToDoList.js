import Card from "../UI/Card";
import Table from "react-bootstrap/Table";
import classes from "./ToDoList.module.css";
import React, { useState, useEffect } from "react";

function ToDoList() {
  const [dateState, setDateState] = useState(new Date());
  const [todolist, setTodolist] = useState([]);

  useEffect(() => {
    setInterval(() => setDateState(new Date()), 30000);

    var API = "http://localhost:8080/coordinator/todolist";
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
    };

    fetch(API, requestOptions)
      .then((res) => {
        res.json().then((data) => {
          console.log(data);
          setTodolist(data);
        });
      })
      .catch((e) => {
        console.log(e);
      });
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
      <div className={classes.scrollable}>
        <Table>
          <thead>
            <tr key="head">
              <th scope="col"> Completed</th>
              <th scope="col">Description</th>
              <th scope="col">Due Date</th>
            </tr>
          </thead>
          <tbody>
            {todolist.map((task) => (
              <tr>
                <th scope="row" key={task.id}>
                  <div className="form-check">
                    <input
                      className="form-check-input"
                      type="checkbox"
                      key={`checkbox-${task.id}`}
                      value=""
                      id="flexCheckDefault"
                    />
                  </div>
                </th>
                <td>{task.description}</td>
                <td>{task.dueDate}</td>
              </tr>
            ))}
            
          </tbody>
        </Table>
      </div>
    </Card>
  );
}
export default ToDoList;
