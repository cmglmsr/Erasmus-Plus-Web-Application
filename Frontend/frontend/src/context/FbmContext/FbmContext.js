import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";
export const FbmContext = createContext();

export const FbmProvider = ({ children }) => {

  const [fbmData, setfbmData] = useState([]);
  const [role, setRole] = useState("");

  useEffect(() => {
    var API = "http://localhost:8080/fbm/home";
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
    };

    fetch(API, requestOptions).then((res) =>
      res.json().then((data) => {
        setfbmData(data);
        setRole(data.role.name);
        localStorage.setItem("role", data.role.name);
      })
    );
  }, []);

  console.log(fbmData);
  return (
    <FbmContext.Provider value={[fbmData, role]}>
      {children}
    </FbmContext.Provider>
  );
};
export default FbmContext;