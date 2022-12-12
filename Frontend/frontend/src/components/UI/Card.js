import { Container } from "react-bootstrap";
import classes from "./Card.module.css";

function Card(props) {
  return (
    <div className={classes.card}>
      <Container className={classes.container}>{props.children}</Container>
    </div>
  );
}

export default Card;
