import React, {useContext, useEffect, useState} from 'react';
import {useMutation} from "react-query";
import axios from "axios";
import AuthContext from "../context/AuthContext";

const SignIn = () => {
  const authContext = useContext(AuthContext);
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  type ResponseType = {
    id: number,
    username: string,
    email: string,
    accessToken: string,
    roles: string[];
  }

  const login = async (): Promise<ResponseType> => {
    const response = await axios.post("http://localhost:8080/api/auth/signin", {
      username: username,
      password: password
    })
    console.log(response.data);
    return response.data;
  }

  const mutation = useMutation(login);

  useEffect(() => {
    if(mutation.isSuccess) {
      authContext.setUserInfo({
        id: mutation.data.id,
        username: mutation.data.username,
        email: mutation.data.email,
        role: mutation.data.roles[0]
      })
     if(mutation.data.roles[0] === "ROLE_ADMIN") {
       authContext.setRole("admin")
     } else {
       authContext.setRole("user")
     }
    }
  }, [mutation.isSuccess])

  return (
    <div className="max-w-screen-xl mx-auto w-full py-4 flex flex-col items-center mt-auto">
      <h2 className="text-2xl font-medium pb-8">Sign in</h2>
      <div className="form-control w-full max-w-xs space-y-4">
        <div>
          <label className="label">
            <span className="label-text">Username</span>
          </label>
          <input onChange={(event) => setUsername(event.target.value)} type="text" placeholder="Type here" className="input input-bordered w-full max-w-xs"/>
        </div>

        <div className="pb-2">
          <label className="label">
            <span className="label-text">Password</span>
          </label>
          <input onChange={(event) => setPassword(event.target.value)} type="password" placeholder="Type here" className="input input-bordered w-full max-w-xs"/>
        </div>
        <button onClick={() => mutation.mutate()} className="btn">Submit</button>
        <>
          {mutation.isError && <p>incorrect username/password</p>}
          {mutation.isSuccess && (<p>login successful!</p>)}
        </>
      </div>
    </div>
  );
};

export default SignIn;
