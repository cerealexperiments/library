import React from "react";
import styles from "./About.module.css";

function About() {
  return (
    <div className={styles.about}>
      <h2 className={styles.heading}>About</h2>
      <p className={styles.text}>
        In our digital library you can buy or rent any book you want, but should
        you? Piracy is free.
      </p>
    </div>
  );
}

export default About;
