import React from 'react';
import Book from "./Book.jsx";

function BooksList({ books }) {
  return (
    <div className="grid grid-cols-1 justify-items-center sm:grid-cols-2 md:grid-cols-3 gap-8 ">
      {books.map(book => <Book key={book.id} book={book}/>)}
    </div>
  );
}

export default BooksList;