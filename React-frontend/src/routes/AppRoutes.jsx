import { Routes, Route, Navigate } from "react-router-dom";
import Login from "../pages/Login";
import Dashboard from "../pages/Dashboard";
import Products from "../pages/Products";
import Orders from "../pages/Orders";
import Receiving from "../pages/Receiving";
import Inventory from "../pages/Inventory";
import Warehouse from "../pages/Warehouse";
import DashboardLayout from "../layouts/DashboardLayout";
import Barcode from "../pages/Barcode";

const AppRoutes = () => {
  return (
    <Routes>
      <Route path="/" element={<Login />} />

      <Route element={<DashboardLayout />}>
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/products" element={<Products />} />
        <Route path="/orders" element={<Orders />} />
        <Route path="/receiving" element={<Receiving />} />
        <Route path="/inventory" element={<Inventory />} />
        <Route path="/warehouse" element={<Warehouse />} />
        <Route path="/barcode" element={<Barcode />} />
      </Route>

      <Route path="*" element={<Navigate to="/" />} />
    </Routes>
  );
};

export default AppRoutes;