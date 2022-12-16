import Card from "../UI/Card";
import Button from "react-bootstrap/Button";
import Row from "react-bootstrap/Row";
import { Link } from "react-router-dom";

const ActionButtons = ({role}) => {
    let buttons = [];
    if (role === "ROLE_STUDENT") {
        buttons[0] = <Button className="button-default" key="application" as={Link} to="/student/getApplication">My Application</Button>;
        buttons[1] = <Button className="button-default" key="createCourseWishlist" as={Link} to="/student/createCourseWishlist">Course Wishlist</Button>;
        buttons[2] = <Button className="button-default" key="uploadPreApproval" as={Link} to="/student/uploadPreApproval">Upload Pre-Approval</Button>;
        buttons[3] = <Button className="button-default" key="uploadLearningAgreement" as={Link} to="/student/uploadLearningAgreement">Upload Learnin Agreement</Button>;
    }
    else if (role === "ROLE_ISO") {
        buttons[0] = <Button className="button-default" key="transcripts" as={Link} to="/transcripts">Transcripts</Button>;
    }
    else if (role === "ROLE_INSTRUCTOR" || role === "ROLE_COORDINATOR") {
        buttons[0] = <Button className="button-default" key="application-list" as={Link} to="/application-list">Applications</Button>;
        buttons[1] = <Button className="button-default" key="placements" as={Link} to="/placements">Placements</Button>;
        buttons[2] = <Button className="button-default" key="pre-approvals" as={Link} to="/pre-approvals">Pre-Approvals</Button>;
        buttons[3] = <Button className="button-default" key="course-transfer-list" as={Link} to="/course-transfer-list">Course Transfer</Button>;
    }
    if (role === "ROLE_COORDINATOR") {
        buttons[4] = <Button className="button-default" key="final-course-transfer" as={Link} to="/final-course-transfer">Final Course Transfer</Button>;
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