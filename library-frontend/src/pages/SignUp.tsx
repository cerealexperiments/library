import React, {useState} from 'react';
import axios from "axios";
import {useMutation} from "react-query";

const SignUp = () => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const registerUser = async () => {
    await axios.post("http://localhost:8080/api/auth/signup", {
      email: email,
      username: email,
      password: password,
      role: [
        "user",
      ]
    })
  }

  const mutation = useMutation(registerUser);

  return (
    <div className="max-w-screen-xl mx-auto w-full py-4 flex flex-col items-center mt-auto">
      <h2 className="text-2xl font-medium pb-8">Sign Up</h2>
      <div className="form-control w-full max-w-xs space-y-4">
        <div>
          <label className="label">
            <span className="label-text">Username</span>
          </label>
          <input onChange={(event) => setUsername(event.target.value)} type="text" placeholder="Type here" className="input input-bordered w-full max-w-xs"/>
        </div>

        <div>
          <label className="label">
            <span className="label-text">Email</span>
          </label>
          <input onChange={(event) => setEmail(event.target.value)} type="text" placeholder="Type here" className="input input-bordered w-full max-w-xs"/>
        </div>

        <div className="pb-2">
          <label className="label">
            <span className="label-text">Password</span>
          </label>
          <input onChange={(event) => setPassword(event.target.value)} type="password" placeholder="Type here" className="input input-bordered w-full max-w-xs"/>
        </div>

        <button onClick={() => mutation.mutate()} className="btn">Submit</button>
        {mutation.isLoading && <p>signing up...</p>}
        {mutation.isSuccess && <p>user registered successfully!</p>}
        {mutation.isError && <p>couldn't register a user</p>}
      </div>
    </div>
  );
};

export default SignUp;
