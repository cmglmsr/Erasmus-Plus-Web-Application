import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./TranscriptList.module.css";
import { TranscriptListContext } from "../../context/TranscriptContext/TranscriptListContext";
import { useContext } from "react";
import { useNavigate } from "react-router-dom";

function TranscriptList() {
  const transcriptList = useContext(TranscriptListContext);
  const navigate = useNavigate();

  function handleInput(e) {
    console.log(e.target.value);
    const uid = e.target.value;
    //navigate(`/coordinator/applications/${uid}`)
  };
  
  return (
    <Card>
      <h3 className="heading my-3">Upload Transcript List</h3>
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
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {transcriptList.map((application) => (
              <tr key={application.uid}>
                <td>{application.fullname}</td>
                <td>{application.id}</td>
                <td>{application.cgpa}</td>
                <td>{application.school ? application.school : "Not Determined"}</td>
                <td>{application.status}</td>
                <td>
                  <Button key={application.uid} value={application.uid} className="button-default" onClick={e => handleInput(e, "value")}>Upload Transcript</Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    </Card>
  );
}

export default TranscriptList;
