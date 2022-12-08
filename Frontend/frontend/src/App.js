import logo from './logo.svg';
import './App.css';
import { Route, Routes } from "react-router-dom";
import Homepage from "./pages/Homepage";
import Layout from "./components/layout/Layout";
import ProfilePage from './pages/ProfilePage';

function App() {
  return (
    <Layout>
      <Routes>
        <Route path="/" exact={true} element={<Homepage />}></Route>
        <Route path="/profile" exact={true} element={<ProfilePage />}></Route>
      </Routes>
    </Layout>
  );
}

export default App;
