import "./App.css";
import { Route, Routes } from "react-router-dom";
import Layout from "./components/layout/Layout";
import ProfilePage from "./pages/ProfilePage";
import HomePage from "./pages/Homepage";
import ApplicationPage from "./pages/ApplicationPage";
import ApplicationListPage from "./pages/ApplicationListPage";
import CoordinatorPage from "./pages/Coordinator/CoordinatorPage";
import InformationPage from "./pages/InformationPage";
import InternationalStudentOfficePage from "./pages/InternationalStudentOffice/InternationalStudentOfficePage";
import StudentPage from "./pages/Student/StudentPage";
import LoginPage from "./pages/LoginPage";
import ViewApplication from "./pages/ViewApplicationPage";
import ViewProfile from "./pages/ViewProfilePage";
import StudentContextLayout from "./context/StudentContext/StudentContextLayout";
import CoordinatorContextLayout from "./context/CoordinatorContext/CoordinatorContextLayout";
import StudentProfile from "./pages/Student/StudentProfile";
import CoordinatorProfile from "./pages/Coordinator/CoordinatorProfile";

const DUMMY_PROFILE = {
  role: "Student",
  image: "https://cdn-icons-png.flaticon.com/512/3135/3135823.png",
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
        <Route
          path="/"
          exact={true}
          element={<HomePage profile={DUMMY_PROFILE} />}
        ></Route>
        <Route path="/login" exact={true} element={<LoginPage />}></Route>
        <Route
          path="/profile"
          exact={true}
          element={<ProfilePage profile={DUMMY_PROFILE} />}
        ></Route>
        <Route
          path="/application-list"
          exact={true}
          element={<ApplicationListPage profile={DUMMY_PROFILE} />}
        ></Route>
        <Route
          path="/informationPage"
          exact={true}
          element={<InformationPage />}
        ></Route>
        <Route
          path="/internationalStudentOffice/home"
          exact={true}
          element={<InternationalStudentOfficePage />}
        ></Route>
        <Route
          path="/coordinator/home"
          exact={true}
          element={<CoordinatorPage />}
        ></Route>
        <Route
          path="/instructor/home"
          exact={true}
          element={<CoordinatorPage />}
        ></Route>

        <Route
          path="/viewApplication"
          exact={true}
          element={<ViewApplication profile={DUMMY_PROFILE} />}
        ></Route>
        <Route
          path="/viewProfile"
          exact={true}
          element={<ViewProfile profile={DUMMY_PROFILE} />}
        ></Route>
        <Route element={<StudentContextLayout />}>
          <Route
            path="/student/home"
            exact={true}
            element={<StudentPage />}
          ></Route>
          <Route
            path="/student/profile"
            exact={true}
            element={<StudentProfile />}
          ></Route>
          <Route
            path="/student/createApplication"
            exact={true}
            element={<ApplicationPage profile={DUMMY_PROFILE} />}
          ></Route>
        </Route>
        <Route element={<CoordinatorContextLayout />}>
          <Route
            path="/coordinator/home"
            exact={true}
            element={<CoordinatorPage />}
          ></Route>
          <Route
            path="/coordinator/profile"
            exact={true}
            element={<CoordinatorProfile />}
          ></Route>
        </Route>
      </Routes>
          
    </Layout>
  );
}
export default App;
