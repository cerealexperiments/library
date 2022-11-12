import React from 'react';
import { motion } from "framer-motion";

function Home() {
  return (
    <motion.div
      initial={{opacity: 0}}
      animate={{opacity: 1}}
      exit={{opacity: 0}}
      className="hero min-h-[750px]"
      style={{ backgroundImage: `url("https://c1.wallpaperflare.com/preview/127/366/443/library-book-bookshelf-read.jpg")` }}>
      <div className="hero-overlay bg-opacity-60"></div>
      <div className="hero-content text-center text-neutral-content">
        <div className="max-w-md">
          <h1 className="mb-5 text-5xl font-bold">Welcome</h1>
          <p className="mb-5">Please sign up to get access to all features of our library</p>
          <button className="btn btn-outline bg-white border-white hover:bg-white hover:text-black hover:border-white">Get Started</button>
        </div>
      </div>
    </motion.div>
  );
}

export default Home;