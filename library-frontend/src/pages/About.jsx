import React from 'react';
import {motion} from "framer-motion";

function About() {
  return (
    <motion.div
      initial={{opacity: 0}}
      animate={{opacity: 1}}
      exit={{opacity: 0}}>
      <h2 className="font-semibold text-xl">About</h2>
      <p className={"pt-4"}>In this e-library you can buy any book you want, but should you? Piracy has always been free.</p>
    </motion.div>
  );
}

export default About;