import { useEffect, useMemo } from "react";
import { useState } from "react";
import { createContext } from "react";

export const CoordinatorContext = createContext();
export const CoordinatorProvider = ({ children }) => {
  var API = "http://localhost:8080/coordinator/home";

  const [coordinatorData, setcoordinatorData] = useState([]);
  const [role, setRole] = useState("");

  useEffect(() => {
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
        setcoordinatorData(data);
        setRole(data.role.name);
      })
    );
  }, []);

  const contextValue = useMemo(() => {
    return { coordinatorData, role };
  }, [coordinatorData, role])

  console.log(coordinatorData);
  return (
    <CoordinatorContext.Provider value={contextValue}>
      {children}
    </CoordinatorContext.Provider>
  );
};
export default CoordinatorContext;
