import { useState } from "react";
import API from "../services/api";

const Orders = () => {
  const [data, setData] = useState({});

  const createOrder = async () => {
    await API.post("/orders", data);
    alert("Order Created");
  };

  return (
    <div>
      <button onClick={createOrder} className="bg-green-500 text-white p-2">
        Create Order
      </button>
    </div>
  );
};

export default Orders;