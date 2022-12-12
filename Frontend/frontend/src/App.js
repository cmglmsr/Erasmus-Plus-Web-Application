import './App.css';
import { Route, Routes } from "react-router-dom";
import Layout from "./components/layout/Layout";
import ProfilePage from './pages/ProfilePage';
import HomePage from './pages/Homepage';
import ApplicationPage from './pages/ApplicationPage';
import ApplicationListPage from './pages/ApplicationListPage';
import CoordinatorHomePage from './pages/CoordionatorHomePage';
import InformationPage from './pages/InformationPage';
import InternationalStudentOffice from './pages/InternationalStudentOffice';
import Student from './pages/Student';
import LoginPage from "./pages/LoginPage";


const DUMMY_PROFILE = {
  role: "Student",
  image:
    "https://cdn-icons-png.flaticon.com/512/3135/3135823.png",
  name: "Elifsena",
  surname: "Oz",
  id: "22002245",
  department: "CS",
  semester: "3",
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
        <Route path="/" exact={true} element={<HomePage profile={DUMMY_PROFILE}/>}></Route>
        <Route path="/login" exact={true} element={<LoginPage/>}></Route>
        <Route path="/profile" exact={true} element={<ProfilePage profile={DUMMY_PROFILE}/>}></Route>
        <Route path="/application" exact={true} element={<ApplicationPage profile={DUMMY_PROFILE}/>}></Route>
        <Route path="/application-list" exact={true} element={<ApplicationListPage profile={DUMMY_PROFILE}/>}></Route>
        <Route path="/info" exact={true} element={<InformationPage/>}></Route>
        <Route path="/international" exact={true} element={<InternationalStudentOffice/>}></Route>
        <Route path="/coordinator" exact={true} element={<CoordinatorHomePage/>}></Route>
        <Route path="/student" exact={true} element={<Student/>}></Route>
      </Routes>
    </Layout>
  );
}

export default App;
