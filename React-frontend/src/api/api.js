import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080"
});

// LOGIN FUNCTION
export const login = async (username) => {
  const res = await API.post("/auth/login", {
    username: username
  });

  // Save JWT token
  localStorage.setItem("token", res.data);

  return res.data;
};
// CALL RECEIVING API
export const receiveStock = async (data) => {

  const token = localStorage.getItem("token");

  return API.post("/receiving", data, {
    headers: {
      Authorization: `Bearer ${token}`
    }
  });
};
export default API;