import Container from "react-bootstrap/esm/Container";
import Card from "../UI/Card";
import Button from "react-bootstrap/Button";
import Row from "react-bootstrap/Row";
import { Link } from "react-router-dom";
import classes from "./ActionButton.module.css";

function ActionButtons(props) {
    var role = props.role;
    let buttons = [];
    if (role === "student") {
        buttons[0] = <Button className={classes.button} as={Link} to="application">My Application</Button>;
    }
    else if (role === "international student office") {
        buttons[0] = <Button className={classes.button} as={Link} to="transcripts">Transcripts</Button>;
    }
    else {
        buttons[0] = <Button className={classes.button} as={Link} to="applications">Applications</Button>;
        buttons[1] = <Button className={classes.button} as={Link} to="placements">Placements</Button>;
        buttons[2] = <Button className={classes.button} as={Link} to="pre-approvals">Pre-Approvals</Button>;
        buttons[3] = <Button className={classes.button} as={Link} to="course-transfer-list">Course Transfer</Button>;
    }
    if (role === "coordinator") {
        buttons[4] = <Button className={classes.button} as={Link} to="final-course-transfer">Final Course Transfer</Button>;
    }

    const results= []
    buttons.forEach(button => {
        results.push(
            <Row  className="m-2">
                {button}
            </Row>
        );
    })

    return(
        <Card>
            <Container>
                {results}
            </Container>
        </Card>
    )
}

export default ActionButtons;