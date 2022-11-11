import { createContext } from "react";
import {useQuery} from "@tanstack/react-query";
import axios from "axios";

const BooksContext = createContext({});

const fetchBooks = async() => {
  const response = await axios.get("http://127.0.0.1:8090/api/collections/books/records");
  console.log(response.data);
  return response.data.items;
}

export const BooksProvider = ({ children }) => {
  const { data, isLoading } = useQuery(["books"], fetchBooks)

  return <BooksContext.Provider value={{data, isLoading}}>
    {children}
  </BooksContext.Provider>
}

export default BooksContext;
