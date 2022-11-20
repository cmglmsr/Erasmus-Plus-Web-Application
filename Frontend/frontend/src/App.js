import logo from './logo.svg';
import './App.css';
import { Route, Routes } from "react-router-dom";
import Homepage from "./pages/Homepage";
import Layout from "./components/layout/Layout";

function App() {
  return (
    <Layout>
      <Routes>
        <Route path="/" exact={true} element={<Homepage />}></Route>
      </Routes>
    </Layout>
  );
}

export default App;
