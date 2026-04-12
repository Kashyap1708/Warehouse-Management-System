import { useContext } from "react";
import { AuthContext } from "../context/AuthContext";

const Navbar = () => {
  const { logout } = useContext(AuthContext);

  return (
    <div className="bg-white shadow p-4 flex justify-between">
      <h1>Dashboard</h1>
      <button onClick={logout} className="bg-red-500 text-white px-3 py-1">
        Logout
      </button>
    </div>
  );
};

export default Navbar;