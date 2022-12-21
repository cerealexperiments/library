import React from 'react';
import Header from "../components/Header";
import { Outlet } from "react-router-dom";
import Footer from "../components/Footer";

const Root = () => {
  return (
    <div className="flex min-h-screen flex-col">
      <Header/>
      <Outlet />
      <Footer/>
    </div>
  );
};

export default Root;
