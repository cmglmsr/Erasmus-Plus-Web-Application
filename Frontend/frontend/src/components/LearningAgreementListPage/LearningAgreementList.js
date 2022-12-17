import Table from "react-bootstrap/Table";
import Button from "react-bootstrap/Button";
import Card from "../UI/Card";
import classes from "./LearningAgreementList.module.css";
import { LearningAgreementListContext } from "../../context/LearningAgreementContext/LearningAgreementListContext";
import { useContext } from "react";
import { useNavigate } from "react-router-dom";


function LearningAgreementList() {
  const learningAgreementList = useContext(LearningAgreementListContext);
  const navigate = useNavigate();
  console.log(learningAgreementList);

  function handleInput(e) {
    console.log(e.target.value);
    const uid = e.target.value;
    //navigate(`/coordinator/applications/${uid}`)
  }

  console.log(learningAgreementList);
  return (
    <Card>
      <h3 className="heading my-3">Learning Agreement List</h3>
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
            {learningAgreementList.map((learningAgreement) => (
              <tr key={learningAgreement.uid}>
                <td className={classes.center}>{learningAgreement.fullName}</td>
                <td className={classes.center}>{learningAgreement.id}</td>
                <td className={classes.center}>{learningAgreement.cgpa}</td>
                <td className= {classes.center}>
                  <Button
                    key={learningAgreement.uid}
                    value={learningAgreement.uid}
                    className="button-default"
                    onClick={(e) => handleInput(e, "value")}
                  >
                    Download
                  </Button>
                </td>
                <td className= {classes.center}>
                  <Button
                    key={learningAgreement.uid}
                    value={learningAgreement.uid}
                    className= {classes.button1}
                    onClick={(e) => handleInput(e, "value")}
                  >
                    Approve
                  </Button>
                </td>
                <td className= {classes.center}>
                  <Button
                    key={learningAgreement.uid}
                    value={learningAgreement.uid}
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

export default LearningAgreementList;
