import React from 'react';
import { useQuery } from "@tanstack/react-query";
import axios from "axios";
import BooksList from "../components/BooksList.jsx";

const fetchBooks = async () => {
  const response = await axios.get("http://127.0.0.1:8090/api/collections/books/records");
  return response.data;
}

function Books() {

  const {data, isLoading} = useQuery(["books"], fetchBooks)

  return (
    <div>
      <h2 className="font-semibold text-lg pb-6">Books</h2>
      {isLoading && <p>Loading...</p>}
      {data && <BooksList books={data.items} />}
    </div>
  );
}

export default Books;