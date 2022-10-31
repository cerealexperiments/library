import React from "react";
import Book from "./Book";
import styles from "./BooksList.module.css";

function BooksList({ books }) {
  return (
    <div className={styles.booksList}>
      {books.map((book) => {
        return (
          <Book
            name={book.name}
            author={book.author}
            price={book.price}
            imgUrl={book.imgUrl}
            key={book.name}
          />
        );
      })}
    </div>
  );
}

export default BooksList;
