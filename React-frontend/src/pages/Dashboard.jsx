

const Dashboard = () => {
  return (
    <div>
      <h1 className="text-3xl font-bold mb-6">Dashboard</h1>

      <div className="grid grid-cols-3 gap-6">

        <div className="bg-white p-6 rounded-2xl shadow hover:scale-105 transition">
          <h2 className="text-gray-500">Total Products</h2>
          <p className="text-3xl font-bold mt-2">120</p>
        </div>

        <div className="bg-white p-6 rounded-2xl shadow hover:scale-105 transition">
          <h2 className="text-gray-500">Orders</h2>
          <p className="text-3xl font-bold mt-2">45</p>
        </div>

        <div className="bg-white p-6 rounded-2xl shadow hover:scale-105 transition">
          <h2 className="text-gray-500">Low Stock</h2>
          <p className="text-3xl font-bold text-red-500 mt-2">5</p>
        </div>

      </div>
    </div>
  );
};

export default Dashboard;