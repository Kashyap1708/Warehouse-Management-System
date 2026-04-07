import { useState } from "react";
import API from "../api/api";

const Orders = () => {
  const [orderId, setOrderId] = useState("");

  const packOrder = async () => {
    await API.post(`/orders/${orderId}/pack`);
    alert("Order Packed");
  };

  return (
    <div>
      <h2 className="text-xl font-bold mb-4">Orders</h2>

      <div className="bg-white p-6 rounded-xl shadow w-96">

        <input
          type="number"
          placeholder="Order ID"
          className="w-full p-2 border rounded mb-4"
          onChange={(e) => setOrderId(e.target.value)}
        />

        <button
          className="bg-blue-600 text-white px-4 py-2 rounded"
          onClick={packOrder}
        >
          Pack Order
        </button>
      </div>
    </div>
  );
};

export default Orders;