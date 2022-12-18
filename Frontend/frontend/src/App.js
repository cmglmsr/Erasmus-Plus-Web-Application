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
import PlacementListContextLayout from "./context/PlacementListContext/PlacementListContextLayout";
import PlacementListPage from "./pages/Coordinator/PlacementListPage";
import PreApprovalUpload from "./pages/Student/PreApprovalUpload";
import LearningAgreementUpload from "./pages/Student/LearningAgreementUpload";
import FbmContextLayout from "./context/FbmContext/FbmContextLayout";
import FbmPage from "./pages/Fbm/FbmPage";
import FbmProfile from "./pages/Fbm/FbmProfile";
import IsoContextLayout from "./context/IsoContext/IsoContextLayout";
import IsoPage from "./pages/Iso/IsoPage";
import IsoProfile from "./pages/Iso/IsoProfile";
import LearningAgreementListPage from "./pages/LearningAgreementListPage";
import LearningAgreementListContextLayout from "./context/LearningAgreementContext/LearningAgreementListContextLayout";
import PreApprovalListContextLayout from "./context/PreApprovalContext/PreApprovalListContextLayout";
import PreApprovalListPage from "./pages/Fbm/PreApprovalListPage";
import SingleWishlistView from "./pages/Instructor/SingleWishlistView";
import CourseWishlistContextLayout from "./context/CourseWishlistContext/CourseWishlistContextLayout";
import CourseWishlistPage from "./pages/Instructor/CourseWishlistPage";
import TranscriptsListPage from "./pages/Iso/TranscriptListPage";
import TranscriptListContextLayout from "./context/TranscriptContext/TranscriptListContextLayout";
import TranscriptSinglePage from "./pages/Iso/TranscriptSinglePage";
import WaitingListPage from "./pages/WaitingListPage";
import WaitingListContextLayout from "./context/WaitingListContext/WaitingListContextLayout";
import StudentProfileEdit from "./pages/Student/StudentProfileEdit";
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
          path="/informationPage"
          exact={true}
          element={<InformationPage />}
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
            path="/student/profile/edit"
            exact={true}
            element={<StudentProfileEdit />}
          ></Route>

          <Route
            path="/student/manageApplication"
            exact={true}
            element={<ManageApplication />}
          ></Route>

          <Route
            path="/student/preApproval"
            exact={true}
            element={<PreApprovalUpload />}
          ></Route>

          <Route
            path="/student/learningAgreement"
            exact={true}
            element={<LearningAgreementUpload />}
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
              path="/student/createCourseWishlist"
              exact={true}
              element={<WishListPage />}
            ></Route>
          </Route>
        </Route>

        <Route element={<CoordinatorContextLayout />}>
          <Route
            path="/coordinator/home"
            exact={true}
            element={<CoordinatorPage />}
          ></Route>

          <Route element={<WaitingListContextLayout />}>
            <Route
              path="/coordinator/waitinglist"
              exact={true}
              element={<WaitingListPage />}
            ></Route>
          </Route>

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

          <Route element={<LearningAgreementListContextLayout />}>
            <Route
              path="/coordinator/learningAgreements"
              exact={true}
              element={<LearningAgreementListPage />}
            ></Route>
          </Route>

          <Route element={<PlacementListContextLayout />}>
            <Route
              path="/coordinator/placements"
              exact={true}
              element={<PlacementListPage />}
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
          <Route element={<CourseWishlistContextLayout />}>
            <Route
              path="/instructor/wishlists/"
              exact={true}
              element={<CourseWishlistPage />}
            ></Route>
          </Route>
          <Route
            path="/instructor/wishlist/:id"
            exact={true}
            element={<SingleWishlistView />}
          ></Route>
        </Route>

        <Route element={<FbmContextLayout />}>
          <Route path="/fbm/home" exact={true} element={<FbmPage />}></Route>
          <Route
            path="/fbm/profile"
            exact={true}
            element={<FbmProfile />}
          ></Route>
          <Route element={<PreApprovalListContextLayout />}>
            <Route
              path="/fbm/preApprovals"
              exact={true}
              element={<PreApprovalListPage />}
            ></Route>
          </Route>
        </Route>

        <Route element={<IsoContextLayout />}>
          <Route path="/iso/home" exact={true} element={<IsoPage />}></Route>
          <Route
            path="/iso/profile"
            exact={true}
            element={<IsoProfile />}
          ></Route>

          <Route element={<TranscriptListContextLayout />}>
            <Route
              path="/iso/transcripts"
              exact={true}
              element={<TranscriptsListPage />}
            ></Route>
            <Route
              path="/iso/transcript/:id"
              exact={true}
              element={<TranscriptSinglePage />}
            ></Route>
          </Route>
        </Route>
      </Routes>
    </Layout>
  );
}
export default App;
