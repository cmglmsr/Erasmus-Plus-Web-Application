import "./App.css";
import { Route, Routes } from "react-router-dom";
import Layout from "./components/layout/Layout";
import ProfilePage from "./pages/ProfilePage";
import ApplicationPage from "./pages/ApplicationPage";
import ApplicationListPage from "./pages/ApplicationListPage";
import CoordinatorPage from "./pages/Coordinator/CoordinatorPage";
import InformationPage from "./pages/InformationPage";
import InternationalStudentOfficePage from "./pages/InternationalStudentOffice/InternationalStudentOfficePage";
import StudentPage from "./pages/Student/StudentPage";
import LoginPage from "./pages/LoginPage";
import ViewProfile from "./pages/ViewProfilePage";
import StudentContextLayout from "./context/StudentContext/StudentContextLayout";
import CoordinatorContextLayout from "./context/CoordinatorContext/CoordinatorContextLayout";
import StudentProfile from "./pages/Student/StudentProfile";
import CoordinatorProfile from "./pages/Coordinator/CoordinatorProfile";
import CreateApplication from "./pages/Student/CreateApplication";
import ApplicationSchoolContextLayout from "./context/ApplicationContext/ApplicationSchoolContextLayout";
import ManageApplication from "./pages/Student/ManageApplication";
import InstructorContextLayout from "./context/InstructorContext/InstructorContextLayout";
import { Navigate } from "react-router";
import InstructorPage from "./pages/Instructor/InstructorPage";
import InstructorProfile from "./pages/Instructor/InstructorProfile";
import ApplicationListContextLayout from "./context/ApplicationContext/ApplicationListContextLayout";
import SingleApplicationView from "./pages/SingleApplicationView";
import WishListPage from "./pages/WishListPage";
import ViewWishlistsPage from "./pages/ViewWishlistsPage";

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
        <Route path="/" element={<Navigate to="login" />}></Route>
        <Route path="/login" exact={true} element={<LoginPage />}></Route>
        <Route
          path="/profile"
          exact={true}
          element={<ProfilePage profile={DUMMY_PROFILE} />}
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

          <Route element={<ApplicationSchoolContextLayout />}>
            <Route
              path="/student/createApplication"
              exact={true}
              element={<CreateApplication />}
            ></Route>

            <Route
              path="/student/getApplication"
              exact={true}
              element={<ApplicationPage />}
            ></Route>

            <Route
              path="/student/manageApplication"
              exact={true}
              element={<ManageApplication />}
            ></Route>
          </Route>
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
          <Route element={<ApplicationListContextLayout />}>
            <Route
              path="/coordinator/applications"
              exact={true}
              element={<ApplicationListPage />}
            ></Route>
          </Route>
          
          <Route
              path="/coordinator/applications/:uid"
              exact={true}
              element={<SingleApplicationView />}
            ></Route>
        </Route>

        <Route element={<InstructorContextLayout />}>
          <Route
            path="/instructor/home"
            exact={true}
            element={<InstructorPage />}
          ></Route>
          <Route
            path="/instructor/profile"
            exact={true}
            element={<InstructorProfile />}
          ></Route>
        </Route>

        <Route path="/wishlist" exact={true} element={<WishListPage />}></Route>

        <Route
          path="/viewWishlists"
          exact={true}
          element={<ViewWishlistsPage/>}
        ></Route>
      </Routes>
    </Layout>
  );
}
export default App;
