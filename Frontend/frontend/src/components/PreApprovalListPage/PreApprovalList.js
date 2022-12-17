import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./PreApprovalList.module.css";
import PreApprovalListContext from "../../context/PreApprovalContext/PreApprovalListContext";
import { useContext } from "react";
import { useNavigate } from "react-router-dom";


function PreApprovalList() {
  const preApprovalList = useContext(PreApprovalListContext);
  const navigate = useNavigate();
  console.log(preApprovalList);

  function handleInput(e) {
    console.log(e.target.value);
    const uid = e.target.value;
    //navigate(`/coordinator/applications/${uid}`)
  }

  console.log(preApprovalList);
  return (
    <Card>
      <h3 className="heading my-3">Preapproval List</h3>
      <hr />
      <div className={classes.scrollable}>
        <Table>
          <thead>
            <tr key="head">
              <th className={classes.heading}>Fullname</th>
              <th className={classes.heading}>ID </th>
              <th className={classes.heading}>CGPA</th>
              <th className={classes.heading}>Download</th>
              <th className={classes.heading}>Approve</th>
              <th className={classes.heading}>Reject</th>
            </tr>
          </thead>
          <tbody>
            {preApprovalList.map((preApproval) => (
              <tr key={preApproval.uid}>
                <td className={classes.center}>{preApproval.fullName}</td>
                <td className={classes.center}>{preApproval.id}</td>
                <td className={classes.center}>{preApproval.cgpa}</td>
                <td className= {classes.center}>
                  <Button
                    key={preApproval.uid}
                    value={preApproval.uid}
                    className="button-default"
                    onClick={(e) => handleInput(e, "value")}
                  >
                    Download
                  </Button>
                </td>
                <td className= {classes.center}>
                  <Button
                    key={preApproval.uid}
                    value={preApproval.uid}
                    className= {classes.button1}
                    onClick={(e) => handleInput(e, "value")}
                  >
                    Approve
                  </Button>
                </td>
                <td className= {classes.center}>
                  <Button
                    key={preApproval.uid}
                    value={preApproval.uid}
                    className = {classes.button2}
                    onClick={(e) => handleInput(e, "value")}
                  >
                    Reject
                  </Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    </Card>
  );
}

export default PreApprovalList;