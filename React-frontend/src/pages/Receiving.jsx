import { useState } from "react";
import API from "../api/api";

const Receiving = () => {
  const [productId, setProductId] = useState("");
  const [quantity, setQuantity] = useState("");

  const handleSubmit = async () => {
    await API.post("/receiving", {
      productId,
      quantity,
      warehouseId: 1
    });

    alert("Stock Added");
  };

  return (
    <div>
      <h2 className="text-xl font-bold mb-4">Receiving</h2>

      <div className="bg-white p-6 rounded-xl shadow w-96">

        <input
          type="number"
          placeholder="Product ID"
          className="w-full p-2 border rounded mb-4"
          onChange={(e) => setProductId(e.target.value)}
        />

        <input
          type="number"
          placeholder="Quantity"
          className="w-full p-2 border rounded mb-4"
          onChange={(e) => setQuantity(e.target.value)}
        />

        <button
          className="bg-green-600 text-white px-4 py-2 rounded"
          onClick={handleSubmit}
        >
          Submit
        </button>
      </div>
    </div>
  );
};

export default Receiving;