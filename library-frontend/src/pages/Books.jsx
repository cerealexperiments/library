import React, { useContext } from 'react';
import BooksList from "../components/BooksList.jsx";
import BooksContext from "../context/BooksContext.jsx";

function Books() {

  const { data, isLoading } = useContext(BooksContext);

  return (
    <div>
      <h2 className="font-semibold text-lg pb-6">Books</h2>
      {isLoading && <p>Loading...</p>}
      {data && <BooksList books={data} />}
    </div>
  );
}

export default Books;