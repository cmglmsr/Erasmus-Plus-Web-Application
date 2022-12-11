import './App.css';
import { Route, Routes } from "react-router-dom";
import Layout from "./components/layout/Layout";
import ProfilePage from './pages/ProfilePage';
import HomePage from './pages/Homepage';
import ApplicationPage from './pages/ApplicationPage';
import ApplicationListPage from './pages/ApplicationListPage';
import CoordinatorHomePage from './pages/CoordionatorHomePage';
import InformationPage from './pages/InformationPage';


const DUMMY_PROFILE = {
  role: "coordinator",
  image:
    "https://media-exp1.licdn.com/dms/image/D4D03AQEdRKW_KFlPHQ/profile-displayphoto-shrink_800_800/0/1665401571688?e=1675900800&v=beta&t=gv1Z-1e1Qwaglyupyd0o10c5YeCiO95fqjnqUtoc6fI",
  name: "Elifsena",
  surname: "Oz",
  id: "22002245",
  department: "CS",
  email: "elifsena.oz@ug.bilkent.edu.tr",
  dateOfBirth: "25.06.2002",
  nationalID: "11223344556",
  phone: "05051231234",
  gender: "female",
};

function App() {
  return (
    <Layout>
      <Routes>
        <Route path="/" exact={true} element={<InformationPage/>}></Route>
      </Routes>
    </Layout>
  );
}

export default App;
