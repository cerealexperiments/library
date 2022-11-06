import React from "react";
import styles from "./AddBook.module.css";
import { useState } from "react";


function AddBook() {
  const [title, setTitle] = useState("");
  const [author, setAuthor] = useState("");
  const [imgUrl, setImgUrl] = useState("");
  const [price, setPrice] = useState("");

  const addBook = () => {
    fetch("http://localhost:9090/api/v1/books/save-book", {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify({
        author_id: 1,
        name: title,
        image_url: imgUrl,
        price: price,
      })
    }).then(response => {
      console.log(response);
    })
  }

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
              value={imgUrl}
              onChange={(e) => setImgUrl(e.target.value)}
              type="url"
              placeholder="Image url..."
              className={styles.input}
          />
          <input
              value={price}
              onChange={(e) => setPrice(Number(e.target.value))}
              type="number"
              placeholder="Price..."
              className={styles.input}
          />
          <button onClick={(e) => {
            e.preventDefault();
            addBook();
          }} className={styles.button}>Submit</button>
        </form>
      </div>
  );
}

export default AddBook;