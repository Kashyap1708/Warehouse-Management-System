import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const { login } = useContext(AuthContext);
  const [username, setUsername] = useState("");
  const navigate =useNavigate();

  const handleLogin=async()=>{
    try{
      await login(username);
      navigate("/dashboard");
    }
    catch(err){
      console.log(err);
      alert("Login failed");
    }
  };
  return (
    <div className="flex items-center justify-center h-screen">
      <div className="p-6 shadow bg-white">
        <input
        value={username}
          placeholder="Username"
          className="border p-2"
          onChange={(e) => setUsername(e.target.value)}
        />
        <button
          className="bg-blue-500 text-white px-4 py-2 ml-2"
          onClick={async() =>{
            const success=await login(username);
            if(success){
              navigate("/dashboard");
            }
          }}
        >
          Login
        </button>
      </div>
    </div>
  );
};

export default Login;