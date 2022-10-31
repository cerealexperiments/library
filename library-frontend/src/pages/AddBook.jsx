import React from "react";
import styles from "./AddBook.module.css";
import { useState } from "react";

function AddBook() {
  const [title, setTitle] = useState("");
  const [author, setAuthor] = useState("");
  const [price, setPrice] = useState("");

  return (
    <div>
      <h2 className={styles.heading}>Add New Book</h2>
      <form className={styles.form}>
        <input
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          type="text"
          placeholder="Title..."
          className={styles.input}
        />
        <input
          value={author}
          onChange={(e) => setAuthor(e.target.value)}
          type="text"
          placeholder="Author..."
          className={styles.input}
        />
        <input
          value={price}
          onChange={(e) => setPrice(Number(e.target.value))}
          type="number"
          placeholder="Price..."
          className={styles.input}
        />
        <button className={styles.button}>Submit</button>
      </form>
    </div>
  );
}

export default AddBook;
