import React from 'react';
import Book from "./Book.jsx";

function BooksList({ books }) {
  return (
    <div className="flex gap-8 flex-wrap">
      {books.map(book => <Book key={book.id} book={book}/>)}
    </div>
  );
}

export default BooksList;