import { createContext, useState } from "react";
import API from "../services/api";

export const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);

  const login = async (username) => {
    try {
      const res = await API.post("/auth/login", { username });
      console.log("TOKEN:",res.data);
      localStorage.setItem("token", res.data);

      // fake role decode (backend me role add karo later)
      setUser({ username, role: username === "admin" ? "ADMIN" : "EMPLOYEE" });
     return true;
    } catch (err) {
      alert("Login failed");
      return false;
    }
  };

  const logout = () => {
    localStorage.clear();
    setUser(null);
  };

  return (
    <AuthContext.Provider value={{ user, login, logout }}>
      {children}
    </AuthContext.Provider>
  );
};