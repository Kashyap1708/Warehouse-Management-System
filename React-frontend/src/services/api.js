import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8080",
});
export const getBarcode = async (sku) => {
  return API.get(`/barcode/${sku}`, {
    responseType: "blob", // VERY IMPORTANT (image)
  });
};
// Interceptor (JWT attach)
API.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default API;