import React from 'react';
import { Link } from "react-router-dom";
import LoginButton from "./LoginButton.jsx";
import SignupButton from "./SignupButton.jsx";

function Header() {
  return (
    <div className="navbar bg-base-100 pb-12 p-0">
      <div className="navbar-start">
        <div className="dropdown">
          <label tabIndex={0} className="btn btn-ghost lg:hidden">
            <svg xmlns="http://www.w3.org/2000/svg" className="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor"><path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 6h16M4 12h8m-8 6h16" /></svg>
          </label>
          <ul tabIndex={0} className="menu menu-compact dropdown-content mt-3 p-2 shadow bg-base-100 rounded-box w-52">
            <li><Link className="font-medium" to="/about">About</Link></li>
            <li><Link className="font-medium" to="/add-book">Add Book</Link></li>
            <li><Link className="font-medium" to="/books">Books</Link></li>
          </ul>
        </div>
        <h1>
          <Link className="text-2xl font-bold" to="/">Library</Link>
        </h1>
      </div>
      <div className="navbar-center hidden lg:flex">
        <ul className="menu menu-horizontal p-0">
          <li><Link className="font-medium" to="/about">About</Link></li>
          <li><Link className="font-medium" to="/add-book">Add Book</Link></li>
          <li><Link className="font-medium" to="/books">Books</Link></li>
        </ul>
      </div>
      <div className="navbar-end flex items-center gap-3">
        <LoginButton/>
        <SignupButton/>
      </div>
    </div>
  );
}

export default Header;