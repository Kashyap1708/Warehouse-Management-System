import { useEffect, useState } from "react";
import API from "../services/api";
import Table from "../components/Table";
import Form from "../components/Form";

const Products = () => {
  const [data, setData] = useState([]);
  const [formData, setFormData] = useState({});

  const fetchData = async () => {
    const res = await API.get("/products");
    setData(res.data);
  };

  useEffect(() => { fetchData(); }, []);

  const handleSubmit = async (e) => {
    e.preventDefault();
    await API.post("/products", formData);
    fetchData();
  };

  return (
    <div>
      <Form fields={["name","sku","category","quantity"]} formData={formData} setFormData={setFormData} onSubmit={handleSubmit} />
      <Table data={data} />
    </div>
  );
};

export default Products;