import React from "react";
import Book from "../components/Book";
import BooksList from "../components/BooksList";
import styles from "./Home.module.css";

function Home({ books }) {
  return (
    <div>
      <h2 className={styles.subheading}>Recently Uploaded</h2>
      <BooksList books={books} />
    </div>
  );
}

export default Home;
