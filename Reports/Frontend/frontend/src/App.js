import logo from './logo.svg';
import './App.css';
import { Route, Routes } from "react-router-dom";
import Homepage from "./pages/Homepage";
import Layout from "./components/layout/Layout";
import ProfilePage from './pages/ProfilePage';
import CoordinatorHomePage from './pages/CoordionatorHomePage';
import ToDoList from './components/HomePage/ToDoList';
import Schedule from './components/HomePage/Schedule';

function App() {
  return (
    <Layout>
      <Routes>
        <Route path="/" exact={true} element={<CoordinatorHomePage/>}></Route>
      </Routes>
    </Layout>
  );
}

export default App;
