import { useEffect, useState } from "react";
import API from "../services/api";

const Warehouse = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    API.get("/warehouse").then(res => setData(res.data));
  }, []);

  return (
    <div>
      {data.map(w => <div key={w.id}>{w.name}</div>)}
    </div>
  );
};

export default Warehouse;