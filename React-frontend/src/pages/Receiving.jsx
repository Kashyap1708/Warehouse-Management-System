import { useState } from "react";
import API from "../services/api";

const Receiving = () => {
  const [data, setData] = useState({});

  const submit = async () => {
    await API.post("/receiving", data);
    alert("Stock Received");
  };

  return (
    <div>
      <input placeholder="productId" onChange={(e)=>setData({...data,productId:e.target.value})}/>
      <input placeholder="quantity" onChange={(e)=>setData({...data,quantity:e.target.value})}/>
      <button onClick={submit}>Submit</button>
    </div>
  );
};

export default Receiving;