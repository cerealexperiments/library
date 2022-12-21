import React from 'react';
import { IoPersonCircleOutline } from "react-icons/io5";
import { Link } from "react-router-dom";
import { useContext } from "react";
import AuthContext from "../context/AuthContext";

const Header = () => {
  const authContext = useContext(AuthContext);

  return (
    <div className="max-w-screen-xl mx-auto navbar p-0 bg-base-100">
      <div className="flex-1">
        <Link to="/" className="text-xl font-semibold hover:text-primary transition-all">Library</Link>
      </div>
      <div className="flex-none">
        <ul className="menu menu-horizontal px-1 space-x-2 pr-0">
          {authContext.role === "admin" && <li>
            <Link to="/add">Add Book</Link>
          </li>}
          <li>
            <Link to="/books">Books</Link>
          </li>
          <li>
            <Link to="/about">About</Link>
          </li>

          <div className="dropdown dropdown-end">
            <label tabIndex={0} className="btn btn-ghost btn-circle avatar">
              <div className="w-10 rounded-full">
                <IoPersonCircleOutline style={{width: "100%", height: "100%"}}/>
              </div>
            </label>
            <ul tabIndex={0} className="menu menu-compact dropdown-content mt-3 p-2 shadow bg-base-100 rounded-box w-52">
              {authContext.role === "user" || authContext.role === "admin" ? (<div>
                <li>
                <Link to="/profile" className="w-full">Profile</Link>
              </li>
                <li>
                <Link to="/favorites" className="w-full">Favorite books</Link>
                </li>
              </div>) : (<div>
                <li>
                  <Link to="/signin" className="w-full">Sign In</Link>
                </li>
                <li>
                  <Link to="/signup" className="w-full">Sign Up</Link>
                </li>
              </div>)}
            </ul>
          </div>
        </ul>
      </div>
    </div>
  );
};

export default Header;
