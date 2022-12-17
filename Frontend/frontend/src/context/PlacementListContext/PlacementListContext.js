import { useEffect } from "react";
import { useState } from "react";
import { createContext } from "react";

export const PlacementListContext = createContext();
export const PlacementListProvider = ({ children }) => {
  const [placementList, setPlacementList] = useState([]);

  useEffect(() => {
    var API = "http://localhost:8080/coordinator/placements";
    var requestOptions = {
      method: "GET",
      redirect: "follow",
      credentials: "include",
      headers: {
        "Content-Type": "application/json",
      },
    };

    fetch(API, requestOptions).then((res) => {
        res.json().then((data) => {
            setPlacementList(data);
        });
    }).catch((e) => {console.log(e)});
  }, [setPlacementList]);

  console.log(placementList);
  return (
    <PlacementListContext.Provider value={placementList}>
      {children}
    </PlacementListContext.Provider>
  );
};
export default PlacementListContext;
