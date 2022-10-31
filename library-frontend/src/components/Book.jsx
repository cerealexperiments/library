import React from "react";
import styles from "./Book.module.css";

function Book({ name, author, price, imgUrl }) {
  return (
    <div className={styles.book}>
      <img src={imgUrl} alt="book cover" className={styles.image} />
      <div className={styles.content}>
        <h4 className={styles.name}>{name}</h4>
        <p className={styles.author}>{author}</p>
      </div>
    </div>
  );
}

export default Book;
