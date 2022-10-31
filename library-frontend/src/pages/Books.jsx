import React from "react";
import BooksList from "../components/BooksList";
import styles from "./Books.module.css";

function Books({ books }) {
  return (
    <div>
      <h2 className={styles.heading}>Books</h2>
      <BooksList books={books} />
    </div>
  );
}

export default Books;
