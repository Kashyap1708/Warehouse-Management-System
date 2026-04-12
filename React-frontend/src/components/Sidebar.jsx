import { Link } from "react-router-dom";

const Sidebar = () => {
  return (
    <div className="w-64 bg-gray-900 text-white p-4">
      <h2 className="text-xl mb-6">WMS</h2>
      <ul className="space-y-3">
        <li><Link to="/dashboard">Dashboard</Link></li>
        <li><Link to="/products">Products</Link></li>
        <li><Link to="/orders">Orders</Link></li>
        <li><Link to="/receiving">Receiving</Link></li>
        <li><Link to="/inventory">Inventory</Link></li>
        <li><Link to="/barcode">Barcode</Link></li>
        <li><Link to="/warehouse">Warehouse</Link></li>
      </ul>
    </div>
  );
};

export default Sidebar;