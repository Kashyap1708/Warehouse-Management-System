// src/components/Layout.jsx

import { Link } from "react-router-dom";

const Layout = ({ children }) => {
  const role = localStorage.getItem("role");

  return (
    <div className="flex h-screen bg-gray-100">

      {/* Sidebar */}
      <div className="w-64 bg-blue-900 text-white p-5 flex flex-col">
        <h2 className="text-2xl font-bold mb-6">WMS</h2>

        <ul className="space-y-4">
          <li><Link to="/dashboard">Dashboard</Link></li>

          {role === "OPERATOR" && (
            <li><Link to="/receiving">Receiving</Link></li>
          )}

          {role === "ADMIN" && (
            <li><Link to="/orders">Orders</Link></li>
          )}
        </ul>
      </div>

      {/* Main */}
      <div className="flex-1 flex flex-col">

        {/* Topbar */}
        <div className="bg-white shadow p-4 flex justify-between">
          <h1 className="font-bold">Warehouse System</h1>

          <button
            onClick={() => {
              localStorage.clear();
              window.location.href = "/";
            }}
            className="bg-red-500 text-white px-4 py-1 rounded"
          >
            Logout
          </button>
        </div>

        {/* Content */}
        <div className="p-6 overflow-auto">
          {children}
        </div>
      </div>
    </div>
  );
};

export default Layout;