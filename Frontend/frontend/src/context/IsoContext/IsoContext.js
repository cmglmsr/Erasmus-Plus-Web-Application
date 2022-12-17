import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const IsoContext = createContext();
export const IsoProvider = ({ children }) => {

  const [isoData, setisoData] = useState([]);
  const [role, setRole] = useState("");

  useEffect(() => {
    var API = "http://localhost:8080/iso/home";
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
        setisoData(data);
        setRole(data.role.name);
        localStorage.setItem("role", data.role.name);
      })
    );
  }, []);

  console.log(isoData);
  return (
    <IsoContext.Provider value={[isoData, role]}>
      {children}
    </IsoContext.Provider>
  );
};
export default IsoContext;