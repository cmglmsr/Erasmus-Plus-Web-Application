import './App.css';
import { Route, Routes } from "react-router-dom";
import Layout from "./components/layout/Layout";
import ProfilePage from './pages/ProfilePage';
import HomePage from './pages/Homepage';
import ApplicationPage from './pages/ApplicationPage';
import ApplicationListPage from './pages/ApplicationListPage';
import CoordinatorPage from './pages/CoordionatorPage';
import InformationPage from './pages/InformationPage';
import InternationalStudentOfficePage from './pages/InternationalStudentOfficePage';
import StudentPage from './pages/StudentPage';
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
        <Route path="/information" exact={true} element={<InformationPage/>}></Route>
        <Route path="/internationalStudentOffice/home" exact={true} element={<InternationalStudentOfficePage/>}></Route>
        <Route path="/coordinator/home" exact={true} element={<CoordinatorPage/>}></Route>
        <Route path="/student/home" exact={true} element={<StudentPage />}></Route>
      </Routes>
    </Layout>
  );
}

export default App;
