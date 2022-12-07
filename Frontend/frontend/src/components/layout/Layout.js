import NavigationBar from './NavigationBar';
import classes from "./Layout.module.css";

function Layout(props) {
  return (
    <div>
      <NavigationBar></NavigationBar>
      <main className={classes.main}>{props.children}</main>
    </div>
  );
}
export default Layout;
