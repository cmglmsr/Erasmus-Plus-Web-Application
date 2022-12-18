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
    const id = e.target.value;
    navigate(`/iso/transcript/${id}`)
  };
  
  return (
    <Card>
      <h3 className="heading my-3">Transcript List</h3>
      <hr />
      <div className={classes.scrollable}>
        <Table>
          <thead>
            <tr key="head">
              <th className={classes.heading}>Fullname</th>
              <th className={classes.heading}>ID </th>
              <th className={classes.heading}>CGPA</th>
              <th className={classes.heading}>Placement</th>
              <th className={classes.heading}>Action</th>
            </tr>
          </thead>
          <tbody>
            {transcriptList.map((transcript) => (
              <tr key={transcript.id}>
                <td className={classes.heading}>{transcript.name + " " + transcript.surname}</td>
                <td className={classes.heading}>{transcript.bilkentId}</td>
                <td className={classes.heading}>{transcript.cgpa}</td>
                <td className={classes.heading}>{transcript.school ? transcript.school : "Not Determined"}</td>
                <td className={classes.heading}>
                  <Button key={transcript.id} value={transcript.id} className="button-default" onClick={e => handleInput(e, "value")}>View Transcript</Button>
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
