import Container from "react-bootstrap/esm/Container";
import Card from "../UI/Card";
import Button from "react-bootstrap/Button";
import Row from "react-bootstrap/Row";
import { Link } from "react-router-dom";
import classes from "./ActionButton.module.css";

const ActionButtons = ({role}) => {
    let buttons = [];
    if (role === "Student") {
        buttons[0] = <Button className="button-default" as={Link} to="/application">My Application</Button>;
    }
    else if (role === "International Student Office") {
        buttons[0] = <Button className="button-default" as={Link} to="/transcripts">Transcripts</Button>;
    }
    else {
        buttons[0] = <Button className="button-default" as={Link} to="/application-list">Applications</Button>;
        buttons[1] = <Button className="button-default" as={Link} to="/placements">Placements</Button>;
        buttons[2] = <Button className="button-default" as={Link} to="/pre-approvals">Pre-Approvals</Button>;
        buttons[3] = <Button className="button-default" as={Link} to="/course-transfer-list">Course Transfer</Button>;
    }
    if (role === "Coordinator") {
        buttons[4] = <Button className="button-default" as={Link} to="/final-course-transfer">Final Course Transfer</Button>;
    }

    const results= []
    buttons.forEach(button => {
        results.push(
            <Row  className="m-2" key={button.key}>
                {button}
            </Row>
        );
    })

    return(
        <Card>
            {results}
        </Card>
    )
}

export default ActionButtons;