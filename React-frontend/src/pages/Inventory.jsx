import { useEffect, useState } from "react";
import API from "../services/api";
import Table from "../components/Table";

const Inventory = () => {
  const [data, setData] = useState([]);

  useEffect(() => {
    API.get("/inventory").then(res => setData(res.data));
  }, []);

  return <Table data={data} />;
};

export default Inventory;