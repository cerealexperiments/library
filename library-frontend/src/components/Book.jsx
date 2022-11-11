import React from 'react';
import {useNavigate} from "react-router-dom";

function Book({ book }) {

  const navigate = useNavigate();
  const navigateToBook = (bookId) => {
    navigate(`/books/${bookId}`);
  }

  return (
    <div onClick={() => {
      navigateToBook(book.id);
    }} className="card w-64 bg-base-100 shadow-xl">
      <figure><img className="w-full h-56  object-cover object-top" src={book.image_url} alt="book cover"/></figure>
      <div className="card-body">
        <h2 className="card-title flex justify-between text-base">
          {book.name}
        </h2>
        <p>{book.author_name}</p>
        <div className="card-actions justify-end pt-4">
          <div className="badge badge-outline">{book.genre}</div>
        </div>
      </div>
    </div>
  );
}

export default Book;