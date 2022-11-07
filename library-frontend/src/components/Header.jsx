import React from 'react';
import { Link } from "react-router-dom";

function Header(props) {
  return (
    <div className={"flex items-center justify-between pb-12"}>
      <h1 className={"text-2xl font-bold"}>
        <Link to={"/"}>Library</Link>
      </h1>
      <nav className={"flex items-center gap-5"}>
        <Link to={"/about"} className={"font-medium"}>About</Link>
        <Link to={"/add-book"} className={"font-medium"}>Add Book</Link>
        <Link to={"/books"} className={"font-medium"}>Books</Link>
      </nav>
      <div className={"flex items-center gap-3"}>
        {/*<input type="text" placeholder="Search book here..." className="input text-sm input-bordered w-full max-w-xs shadow-md focus:outline-none"/>*/}
        <button className="btn text-xs font-bold">Create Account</button>
      </div>
    </div>
  );
}

export default Header;